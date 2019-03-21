package testdemo;

/**
 * Author: Sweetie77
 * Created: 2019/3/21
 */
public class TestFirstThread extends Thread {
    //重写run方法,run方法的方法体就是现场执行体
    public void run(){
        for(int i =0; i<100;i++){
            System.out.println(getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName());
            if(i==20){
                new TestFirstThread().start();
                new TestFirstThread().start();

            }
        }
    }
}
