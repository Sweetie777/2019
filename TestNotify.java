package com.bittech.pc;

/**
 * Author: Sweetie77
 * Created: 2019/1/12
 */
public class TestNotify {
    public static void main(String[] args) {
        Object object = new Object();
//        Thread t1 = new Thread(new MyRunnable(true,"生产者A")).start();
        Thread t2 = new Thread(new MyRunnable).start();

    }
}

class MyRunnable implements Runnable {

    //如果是true表示是生产者
    //如果是false表示是消费者
    private final boolean flag;
    private final Object object;



    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }

    private void notifyMethod() {
        String name = Thread.currentThread().getName();
        System.out.println("消费者开始");
        this.object.notify();
        System.out.println("消费者结束");

    }

    private void waitMethod() {
        synchronized (object) {
            while (true) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "生产者开始");
                try {

                    this.object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}