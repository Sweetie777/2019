package testdemo;

/**
 * Author: Sweetie77
 * Created: 2019/3/21
 */
public class TestThreadLocal {
    private static String commStr;
    private static ThreadLocal<String> threadStr = new ThreadLocal<String>();

    public static void main(String[] args) {
        commStr = "main";
        threadStr.set("main");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr ="thread";
                threadStr.set("thread");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(commStr);
        System.out.println(threadStr.get());
    }
    
}
