package com.bittech.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: Sweetie77
 * Created: 2019/1/12
 */
public class TestExecutors {
    public static void main(String[] args) {

        //固定数量的线程的线程池
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        final AtomicInteger count = new AtomicInteger(0);

        for(int i=0; i<100; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"="+count.getAndAdd(1));
                }
            });

        }
    }
}
