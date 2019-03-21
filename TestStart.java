package testdemo;

/**
 * Author: Sweetie77
 * Created: 2019/3/21
 */
public class TestStart {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
        t.start();
        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pong");
    }
}
