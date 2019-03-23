package com.bittech.server.mul;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程聊天室 服务端
 * Author: Sweetie77
 * Created: 2019/3/19
 */
public class MulThreadServer {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket =  new ServerSocket(6666);
            System.out.println("服务器启动..."+serverSocket.getLocalSocketAddress());

            //线程池
            ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
            while (true){
                Socket client = serverSocket.accept();
                System.out.println("有客户端连接到服务器:"+client.getRemoteSocketAddress());
                executorService.execute(new HandlerClient(client));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
