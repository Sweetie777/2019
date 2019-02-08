package com.bittech.chatroom3;

/**
 * Author: Sweetie77
 * Created: 2019/1/16
 */

import java.io.*;
import java.net.*;
import java.applet.Applet;

public class TalkServer {
    public static void main(String args[]) {
        try {
            ServerSocket server = null;
            server = new ServerSocket(6666);
            //创建一个ServerSocket在端口 监听客户请求
            Socket socket = null;
            System.out.println("等待客户连接...");
            socket = server.accept();
            System.out.println("有新的客户端连接，端口号为: " + socket.getPort());
            //使用accept()阻塞等待客户请求，有客户
            //请求到来则产生一个Socket对象，并继续执行
            String line;
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            //由Socket对象得到输出流，并构造PrintWriter对象
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //由系统标准输入设备构造BufferedReader对象
            System.out.println("客户端:" + is.readLine());
            //在标准输出上打印从客户端读入的字符串
            line = in.readLine();
            //从标准输入读入一字符串
            while (!line.equals("bye")) {
                //如果该字符串为 "bye"，则停止循环
                os.println(line);
                //向客户端输出该字符串
                os.flush();
                //刷新输出流，使Client马上收到该字符串
                //System.out.println("服务端:" + line);
                //在系统标准输出上打印读入的字符串
                System.out.println("客户端:" + is.readLine());
                //从Client读入一字符串，并打印到标准输出上
                line = in.readLine();
                //从系统标准输入读入一字符串
            }
            //继续循环
            os.close(); //关闭Socket输出流
            is.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
            server.close(); //关闭ServerSocket
        } catch (Exception e) {
            System.out.println("服务端出现异常,错误为:" + e);
            //出错，打印出错信息
        }
    }
}