package testdemo;

/**
 * Author: Sweetie77
 * Created: 2019/3/20
 */

public class TestRunnableThread implements Runnable {
    private int i;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
            if (i == 20) {
                TestRunnableThread t = new TestRunnableThread();
                new Thread(t, "newThread1").start();
                new Thread(t, "newThread2").start();
            }
        }
    }
}


