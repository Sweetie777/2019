package com.bittech.client.mul;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/3/23
 */

public class ReadDataFromServerThread extends Thread {

    private final Socket client;

    public ReadDataFromServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream clientInput = this.client.getInputStream();
            Scanner scanner = new Scanner(clientInput);
            while (true) {
                String data = scanner.nextLine();
                System.out.println("来自服务端消息：" + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
