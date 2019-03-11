package com.bittech.review.test;

import java.util.Scanner;

/**
 * 计算重复字符串长度
 * in: 字符串长度不超过1000
 * out: 重复子串的长度, 不存在输出0
 * Author: Sweetie77
 * Created: 2019/3/11
 */
public class Main {
    private static int statLen(String X, int k, int j) {
        int curlen = 0;
        while (k < X.length() && j < X.length() && X.charAt(k) ==X.charAt(j)){
            k++;
            j++;
            curlen++;
        }
        return curlen;
    }

    public static int naiveLRS(String x){
        int maxlen = 0;
        int length = x.length();
        for(int i = 0; i<length; i++){
            int len  = 0;
            int k = i;//第一个游标k
            //第二个游标j
            for(int j = i+1; j<length; j++){
                len = statLen(x,k,j);
                if(maxlen<len){
                    maxlen = len;
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String X = scanner.nextLine();
        System.out.println(naiveLRS(X));

    }
}
