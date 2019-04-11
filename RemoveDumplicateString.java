package com.bittech;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/4/11
 */
public class RemoveDumplicateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(process(string));
    }

    private static String process(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        String result = "";
        for (int i = 0; i < n; i++) {
            if (!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                result += s.charAt(i);
            }
        }
        return result;
    }
}
