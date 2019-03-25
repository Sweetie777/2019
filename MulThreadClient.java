package com.bittech.client.mul;

import java.io.IOException;
import java.net.Socket;

/**
 * Author: Sweetie77
 * Created: 2019/3/23
 */

public class MulThreadClient {

    public static void main(String[] args) {
        try {
            //读取地址
            String host = "127.0.0.1";
            if (args.length == 1) {
                host = args[0];
            }
            //读取端口
            int port = 6666;
            if (args.length == 2) {
                try {
                    port = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    port = 6666;
                    System.out.println("指定端口不是有效格式的端口0-65535，采用默认端口" + port);
                }
            }


            Socket client = new Socket(host, port);
            new ReadDataFromServerThread(client).start();
            new WriteDataToServerThread(client).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
