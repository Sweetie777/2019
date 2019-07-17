package base;

/**
 * Author: Sweetie77
 * Created: 2019/7/15
 */
public class Fail_FastDemo {
    public static  int div(int a, int b){
        if(b == 0)
            throw new IllegalArgumentException("除数不能为0!");
        return a/b;
    }
}
