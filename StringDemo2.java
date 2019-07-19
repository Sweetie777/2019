package base;

/**
 * Author: Sweetie77
 * Created: 2019/7/16
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ab";
        String str3 = "c";
        String str4 = str2 + str3;
        String str5 = str2 + str3;
        String str6 = new String("abc");
        String str7 = "ab"+"c";
        String str8 = str2+"c";

        System.out.println(str1 == str6);//F
        System.out.println(str1 == str4);//F
        System.out.println(str4 == str5);//F
        System.out.println(str1 == str7);//T
        System.out.println(str1 == str8);//F
    }
}
