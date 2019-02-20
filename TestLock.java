package com.bittech.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Sweetie77
 * Created: 2019/2/20
 */

public class TestLock {
    public static void main(String[] args) {
        LockRunnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread thread1 = new Thread();
    }
}

class LockRunnable implements Runnable {

    private int tick = 10;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();

            try {
                if (this.tick > 0) {

                    System.out.println(Thread.currentThread().getName() + "剩余票数" + --this.tick);

                    Thread.sleep(1000);

                }
            catch(InterruptedException e){
                    e.printStackTrace();

                }
            }
        }
    }
}