package testdemo;
/**
 * Author: Sweetie77
 * Created: 2019/3/20
 */


class MyThread implements Runnable {
    //重写run()方法
    @Override
    public void run() {
        //获取当前线程的名字
        System.out.println("当前线程" + Thread.currentThread().getName());
        for (int i = 0; i < 30; i++) {
            System.out.println("A");
        }
    }
}

public class TestRunnable {
    public static void main(String[] args) {
        //创建一个任务对象
        MyThread myThread = new MyThread();
        //将实现的Runnable类的实例传入构造函数
        Thread thread = new Thread(myThread);
        thread.start();
        //获取主线程的名字
        System.out.println("主线程: [" + Thread.currentThread().getName()+"]");
        for (int i = 0; i < 30; i++) {
            System.out.println("C");
        }

    }
}
