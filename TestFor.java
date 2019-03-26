package testdemo;

/**
 * Author: Sweetie77
 * Created: 2019/3/25
 */
public class TestFor {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        for (i = 1; i < 10; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }
    }
}
