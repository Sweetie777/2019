package com.bittech.client.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 单线程聊天室 客户端
 * Author: Sweetie77
 * Created: 2019/3/19
 */
public class SingleThreadClient {
    public static void main(String[] args) {
        try {
            //1. 创建Socket客户端,连接指定服务
            Socket socket = new Socket("127.0.0.1",6666);
            System.out.println("客户端创建..."+socket.getLocalAddress());

            //2. Socket发送和接收数据
            //2.1 发送数据
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write("你好服务器.\n");
            //2.2接收数据
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            String message = scanner.nextLine();
            System.out.println("接收到服务器的消息:"+message);

            System.in.read();
            //3. 关闭客户端
            //socket.close();
            //System.out.println("客户端关闭");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
