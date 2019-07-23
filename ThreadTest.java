package thread;

/**
 * Author: Sweetie77
 * Created: 2019/7/16
 */

class Task implements Runnable{
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("A"))
            testA();
        else
            testB();
    }
    private synchronized void testA(){
        System.out.println("A!");
        testB();
        while (true){

        }
    }
    private synchronized void testB(){
        System.out.println("B!");
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task,"A");
        Thread thread2 = new Thread(task,"B");
        thread1.start();
        thread2.start();
    }
}

