package com.bittech.pc;

/**
 * Author: Sweetie77
 * Created: 2019/1/12
 */
public class TestWait {
    public static void main(String[] args) {

        Object object = new Object();

        new Thread(() ->{
            synchronized (object) {
                object.notify();
            }
        }).start();

        synchronized (object){
            System.out.println("同步开始");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("同步结束");
        }
    }
}
