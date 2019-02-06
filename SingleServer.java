package com.bittech.chatroom;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 单线程聊天室服务端
 * Author: Sweetie77
 * Created: 2019/1/8
 * 1.服务器实例化一个ServerSocket对象, 表示通过服务器上的端口通信
 * 2.服务器调用ServerSocket类的accept()方法, 该方法将一直等待, 直到客户端连接到服务器给定的端口
 * 3.服务器正在等待时, 一个客户端实例化一个Socket对象, 指定服务器名称和端口号来请求连接
 * 4.Socket类的构造函数试图将客户端连接指定的服务器和端口号. 如果通信被建立, 则在客户端创建一个Socket对象能够与服务器进行通信
 * 5.在服务器端, accept()方法返回服务器上一个心得socket引用, 改socket连接到客户端的socket
 */
public class SingleServer {

    public static void main(String[] args) throws Exception {
        // 创建服务端Socket，端口号为6666        
        ServerSocket serverSocket = new ServerSocket(6666);
        try {
            System.out.println("等待客户端连接ing...");
            // 等待客户端连接，有客户端连接后返回客户端的Socket对象，否则线程将一直阻塞于此处            
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为: " + client.getPort());
            // 获取客户端的输入输出流            
            Scanner clientInput = new Scanner(client.getInputStream());
            clientInput.useDelimiter("\n");
            PrintStream clientOut = new PrintStream(client.getOutputStream(),
                    true, "UTF-8");
/*            // 读取客户端输入            
            if (clientInput.hasNext()) {
                System.out.println(client.getInetAddress() + "说: " + clientInput.next());

            }
            //向客户端输出
            clientOut.println("Hello I am Server, welcome!");

            //关闭输入输出流
            clientInput.close();
            clientOut.close();
            serverSocket.close();
*/
            while(true){
                System.out.println("请输入要发送的消息!");
                String strToServer;
                if(clientInput.hasNextLine()){
                    strToServer =clientInput.nextLine().trim();
                    clientOut.println(strToServer);
                    //客户端退出标志
                    if(strToServer.equals("bye")){
                        System.out.println("关闭客户端");
                        clientInput.close();
                        clientOut.close();
                    }
                }
            }


        } catch (IOException e) {
            System.err.println("服务端通信出现异常, 错误为" + e);
        }
    }
}

