package daily;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/7/21
 */
public class HuiWen {
    /**
     * 首先将用户输入的字符串变为一个个的char
     * 两个指针同时遍历, 一个从前面开始, 一个从后面开始
     *
     * 查找插入的位置:
     *      将第二个字符串从第一个字符串第一个位置开始尝试插入
     *      直到判断回文的方法返回true
     * @param s
     * @return
     */

    /**
     *
     *  String类: 要求字符串不可变
     *  StringBuffer类: 需要字符串可变且线程安全
     *  StringBuild类: 要求字符串可变 并且 不存在线程安全的问题
     *
     *  通过toString方法, 可以把StringBuffer, StringBuilder转成String
     *  通过构造方法可以把String转成StringBuffer, StringBuilder
     *  但是不能通过强制转换来操作这三个类,即使他们处于同一类集成层次下, 否则会抛出java.lang.ClasscastException异常
     */
    private static boolean isHuiWen(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = 0;
        for(int i = 0; i<=str1.length();i++){
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i, str2);
            if(isHuiWen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
