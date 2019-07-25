package daily;

import java.util.LinkedList;

/**
 * Author: Sweetie77
 * Created: 2019/7/22
 */
public class FindNAndM {

    private static LinkedList<Integer> list = new LinkedList<Integer>();
    //1. 首先判断, 如果n>m, 则n中大于m的数不可能参与组合, 此时置 n = m
    //2. 将最大数n加入且n == m, 则满足条件, 输出
    //3. 将n分两种情况
    //        n如果没有加入, 取n= = n -1, m = m  递归下去
    //        n加入了, 取 n = n -1, m = m- n  递归下去

    public static void findM(int m, int n) {
        if (n < 1 || m < 1)
            return;
        if (m > n) {
            list.add(n);//如果n加入了
            findM(m - n, n - 1);
            list.pop();//如果n没有加入
            findM(m, n - 1);
        } else {
            System.out.print(m);
            for (int i = 0; i < list.size();i++){
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 6;
        findM(m, n);
    }
}

