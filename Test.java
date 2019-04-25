/**
 * Author: Sweetie77
 * Created: 2019/4/25
 */
public class Test {

    private static class practice {
        {
            System.out.println("A");
        }

        static {
            System.out.println("B");
        }

        practice() {
            System.out.println("C");

        }
    }


    static class A {
        public static String name = "hello";

        static {
            System.out.println("A static block1"); //1
        }

        {
            System.out.println("A block3"); //3
        }

        public A() {
            System.out.println("A constructor4"); //4

        }

    }


    static class B extends A {
        public static String childName = "hello";

        static {
            System.out.println("B static block2"); //2
        }

        {
            System.out.println("B block5"); //5
        }

        public B() {
            System.out.println("B constructor6"); //6
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}
