/**
 * Author: Sweetie77
 * Created: 2019/8/29
 */
public class Syn {

    public static void main(String[] args) {

        System.out.println();
    }

}

class B {

    //修饰静态/非静态
    //修饰静态的时候大家调的是同一个
    //修饰非 静态的时候,调用的是每个对象的方法
    synchronized public static void mB(String value) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            System.out.println(value);
        }
    }
    synchronized public void mC(String value) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            System.out.println(value);
        }
    }
}

//用于代码块
class A{
    //对类进行同步
    public static void test(){
        synchronized (A.class){
            System.out.println("haha");
        }
    }
    //对当前对象进行同步
    public void test2(){
        System.out.println("hehe");
    }
}
