package com.tang;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/9/7
 */
public class TuJia {

    public static int devide(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num1 / num2;
        } else {
            return num1 / num2 + 1;
        }
    }

    public static void print(String s, int num) {
        System.out.println(s + "\n" + num);
        System.exit(0);
    }

    public static boolean blink2(int timeLimit, int magic, int distance) {
        int t = devide(20 - magic, 4);
        int t2 = devide(distance, 50);
        if (t + 2 <= timeLimit && t2 >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int magic = sc.nextInt();
        int distance = sc.nextInt();
        int timeLimit = sc.nextInt();
        int t = timeLimit;
        int dis = distance;
        int n = magic / 10;
        int d = n * 50;
        if (timeLimit < n && d < distance) {
            print("No", timeLimit * 50);
        }
        if ((t * 50 >= distance && timeLimit <= n) || (d >= distance && timeLimit >= n)) {
            print("Yes", devide(distance, 50));
        }
        magic -= n * 10;
        timeLimit -= n;
        distance -= d;
        for (; ; ) {
            if (distance <= 0) print("Yes", t - timeLimit);
            if (timeLimit == 0) print("No", dis - distance);
            int recoverTime = devide(10 - magic, 4);
            if (magic >= 6 && distance >= 34 && timeLimit >= 1) {
                timeLimit -= 2;
                distance -= 50;
                magic = magic + 4 - 10;
                continue;
            }
            if (magic >= 2 && distance >= 51 && timeLimit >= 2) {
                timeLimit -= 3;
                distance -= 50;
                magic = magic + 8 - 10;
                continue;
            }
            if (timeLimit >= 7 && distance >= 100) {
                timeLimit -= 7;
                distance -= 100;
                continue;
            }
            timeLimit -= 1;
            distance -= 13;
        }
    }
}

