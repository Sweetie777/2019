package com.bittech.chatroom;

import java.io.Console;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/1/11
 */
public class SingleClient {
    private static Console reader;

    public static void main(String[] args) throws Exception {
        String serverName = "127.0.0.1";
        Integer port = 6666;
        try {
            //创建客户端socket连接服务器
            Socket client = new Socket(serverName, port);
            System.out.println("连接上服务器, 服务器地址为:" + client.getInetAddress());
            //获取输入输出流
            PrintStream out = new PrintStream(client.getOutputStream(),
                    true, "UTF-8");
            Scanner in = new Scanner(client.getInputStream());
            in.useDelimiter("\n");

/*            //向服务器输出内容
            out.println("Hi I am Client!!");

            //读取服务器输入
            if (in.hasNext()) {
                System.out.println("服务器发送消息为:" + in.next());
            }
*/

            while(true){
                if(in.hasNext()){
                    System.out.println("从服务端发来的消息为:"+in.next());
                }
                if(client.isClosed()){
                    System.out.println("客户端已关闭");
                    break;
                }
            }

            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            System.out.println("客户端通信出现异常, 错误为" + e);
        }
    }
}
