package com.bittech.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: Sweetie77
 * Created: 2019/1/12
 */
public class TestThreadPool {
    public static void main(String[] args) {

        //通过自定义的方式创建线程池执行器
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5, 10, 1,
                        TimeUnit.SECONDS, new ArrayBlockingQueue<>(15),
                        new ThreadFactory().newThread());


        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5, 10, 1,
                        TimeUnit.SECONDS, new ArrayBlockingQueue<>(15), new ThreadFactory() {
                    private final AtomicInteger threadId = new AtomicInteger(1);

                    //把创建线程的逻辑交给客户
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                });





    }
}
