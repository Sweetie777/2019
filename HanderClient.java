package com.bittech.chatroom.mul;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import static com.sun.org.apache.xml.internal.security.utils.resolver.ResourceResolver.register;

/**
 * Author: Sweetie77
 * Created: 2019/3/12
 */
public class HanderClient implements Runnable {

    /**
     * 维护所有的连接到服务器的客户端对象
     */

    private static final Map<String, Socket> ONLINE_CLINET_MAP = new ConcurrentHashMap<>();

    private final Socket client;

    public HanderClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = client.getInputStream();
            Scanner scanner = new Scanner(clientInput);//表示从远端的输入台来的

            /*
             消息是按行读取
             1. 注册: register:<userName> 例如: register : 张三
             2. 群聊: groupChat:<message> 例如: groupChat: 大家好
             3. 私聊: privateChat: <userName>: <message>
             4. 退出: bye
             */

            while (true) {
                String data = scanner.nextLine();

                if(data.startsWith("register:")){
                    //注册
                    String userName  = data.split(":")[1];
                    register(userName);
                    continue;
                }
                if(data.startsWith("groupChat")){
                    //群聊
                    String message = data.split(":")[1];
                    groupChat(message);
                    continue;
                }
                if(data.startsWith("privateChat")){
                    //私聊
                    String[] segments = data.split(":");
                    String targetUserName  = segments[1];
                    String message = segments[2];
                    continue;
                }

                if(data.equals("bye")){
                    //表示退出
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //注册
    private void register(String userName){
        ONLINE_CLINET_MAP.put(userName,client);
        printOnlineClient();
        try {
            OutputStream clientOutput = this.client.getOutputStream();
            OutputStreamWriter writer =
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //群聊
    private void groupChat(String message) {
        for(Map.Entry<String,Socket> entry : ONLINE_CLINET_MAP.entrySet()){
            String target = entry.getKey();
        }
    }

    //私聊
    private void privateChat(){

    }

    //退出
    private void bye(){

    }

    //
    private void sendMessage(Socket target, String message){
        //TODO
    }

    //
    private void printOnlineClient(){
        //TODO
    }

}
