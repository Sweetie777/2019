package com.bittech.client.mul;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/3/23
 */

public class WriteDataToServerThread extends Thread {

    private final Socket client;

    public WriteDataToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            OutputStream clientOutput = this.client.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("请输入>>");
                String data = scanner.nextLine();
                writer.write(data + "\n");
                writer.flush();
                if (data.equals("bye")) {
                    break;
                }
            }
            this.client.close();
        } catch (IOException e) {

        }
    }
}
