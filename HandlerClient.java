package com.bittech.server.mul;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Sweetie77
 * Created: 2019/3/19
 */

public class HandlerClient implements Runnable {

    /**
     * 维护所有的连接到服务端的客户端对象
     */
    private static final Map<String, Socket> ONLINE_CLIENT_MAP = new ConcurrentHashMap<>();

    private final Socket client;

    public HandlerClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream clientInput = client.getInputStream();
            Scanner scanner = new Scanner(clientInput);

            /*
              消息是按行读取
              1.注册： register:<userName> 例如： register:张三
              2.群聊： groupChat:<message> 例如： groupChat:大家好
              3.私聊： privateChat:<userName>:<message>
                例如： privateChat:张三:你好，还钱
              4.退出:  bye

             */
            while (true) {
                String data = scanner.nextLine();
                if (data.startsWith("register:")) {
                    String userName = data.split(":")[1];
                    register(userName);
                    continue;
                }
                if (data.startsWith("groupChat:")) {
                    String message = data.split(":")[1];
                    groupChat(message);
                    continue;
                }
                if (data.startsWith("privateChat:")) {
                    String[] segments = data.split(":");
                    String targetUserName = segments[1];
                    String message = segments[2];
                    privateChat(targetUserName, message);
                    continue;
                }
                if (data.equals("bye")) {
                    //表示退出
                    bye();
                    continue;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当前客户端退出
     */
    private void bye() {
        for (Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if (target.equals(this.client)) {
                ONLINE_CLIENT_MAP.remove(entry.getKey());
                break;
            }
        }
        printOnlineClient();

    }

    private String getCurrentUserName() {
        for (Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if (target.equals(this.client)) {
                return entry.getKey();
            }
        }
        return "";
    }

    /**
     * 私聊，给targetUserName发送message
     *
     * @param targetUserName
     * @param message
     */
    private void privateChat(String targetUserName, String message) {
        Socket target = ONLINE_CLIENT_MAP.get(targetUserName);
        if (target == null) {
            this.sendMessage(this.client, "没这个人" + targetUserName, false);
        } else {

            this.sendMessage(target, message, true);
        }
    }

    /**
     * 群聊，发送message
     *
     * @param message
     */
    private void groupChat(String message) {
        for (Map.Entry<String, Socket> entry : ONLINE_CLIENT_MAP.entrySet()) {
            Socket target = entry.getValue();
            if (target.equals(this.client)) {
                continue;
            }
            this.sendMessage(target, message, true);
        }
    }

    /**
     * 以userName为key注册当前用户（Socket client）
     *
     * @param userName
     */
    private void register(String userName) {
        ONLINE_CLIENT_MAP.put(userName, this.client);
        printOnlineClient();
        this.sendMessage(this.client, "恭喜" + userName + "注册成功", false);
    }

    private void sendMessage(Socket target, String message, boolean prefix) {
        OutputStream clientOutput = null;
        try {
            clientOutput = target.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            if (prefix) {
                String currentUserName = this.getCurrentUserName();
                writer.write("<" + currentUserName + "：说>" + message + "\n");
            } else {
                writer.write(message + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印在线客户端
     */
    private void printOnlineClient() {
        System.out.println("当前在线人数：" + ONLINE_CLIENT_MAP.size() + " 用户名如下列表：");
        for (String userName : ONLINE_CLIENT_MAP.keySet()) {
            System.out.println(userName);
        }
    }
}

