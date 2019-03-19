package com.bittech.server.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 单线程聊天室 服务端
 * Author: Sweetie77
 * Created: 2019/3/19
 */
public class SingleThreadServer {
    public static void main(String[] args) {
        //1.创建服务器端的ServerSocket,监听666端口
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
            System.out.println("服务器启动..."+serverSocket.getLocalSocketAddress());

            while(true){
                //2.接收客户端连接
                final Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("接收到客户端连接..."+socket.getRemoteSocketAddress());

                        InputStream inputStream = null;
                        try {
                            //3. 接收和发送数据
                            //3.1 接收数据
                            inputStream = socket.getInputStream();
                            Scanner scanner = new Scanner(inputStream);
                            String message = scanner.nextLine();
                            System.out.println("收到客户端消息:"+message);

                            //3.2 发送数据
                            OutputStream outputStream = socket.getOutputStream();
                            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
                            writer.write("你好客户端,我很好.\n");
                            writer.flush();

                            //关闭
                            //serverSocket.close();
                            System.out.println("服务器关闭");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
