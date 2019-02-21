package com.bittech.test;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/2/20
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int ans = 0;
            ans = c / 2;
            c %= 2;
            if (c == 1) {
                if (a > 0 && b > 0) {
                    a--;
                    b--;
                    ans++;
                } else if (b == 0 && a >= 3) {
                    a -= 3;
                    ans++;
                }
            }
            ans += b / 3;
            b %= 3;
            ans += a / 6;
            a %= 6;
            if (b * 2 + a >= 6) {
                ans++;
            }
            if (ans >= n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        t--;
    }
}
