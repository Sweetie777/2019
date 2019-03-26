package testdemo;

/**
 * Author: Sweetie77
 * Created: 2019/3/25
 * 为了避免溢出所以用double
 */
public class TestFactorial {
    public static void main(String[] args) {
        System.out.println(fac(60));
        }

    private static double fac(int num) {
        if(num==1){
            return 1;
        }else{
            return num*fac(num - 1);
        }
    }
}

