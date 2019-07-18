package base;

/**
 * Author: Sweetie77
 * Created: 2019/7/16
 */
public class MethodTest {

    // A.6 B.10 C.610
    public static void main(String[]args){
        String str ="6";
        test(str);
        System.out.println(str);
    }
    public static void test(String str){
        str += "10";
    }

    /**
     * test中的str和上面的str不是一回事, 只是名字相同, 起迷惑作用
     * main中输出的还是str
     * 可以将test中的str变为str1
     */
}
