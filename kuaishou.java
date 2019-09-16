package com.tang;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/9/16
 */
public class kuaishou {
    public String longest(String s) {
        if ("".equals(s)) {
            return "";
        }
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int sLength = 1;
        int start = 0;
        int[][] arr = new int[len][len];
        for (int i = 0; i < len; i++) {
            arr[i][i] = 1;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                arr[i][i + 1] = 1;
                sLength = 2;
                start = i;
            }
        }
        for (int i = 3; i < len; i++) {
            for (int j = 0; j + i - 1 < len; j++) {
                int end = j + i - 1;
                if (s.charAt(j) == s.charAt(end)) {
                    arr[j][end] = arr[j + 1][end - 1];
                    if (arr[j][end] == 1) {
                        start = j;
                        sLength = i;
                    }
                }
            }
        }
        return s.substring(start, start + sLength);

    }

    public static void notDescArray(String s) {
        String[] str = s.split(",");
        int[] num = new int[str.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        int count = 0;
        if (num.length == 1) {
            System.out.println("1");
        } else {
            if (num[0] > num[1]) {
                ++count;
            }
            if (num[num.length - 1] < num[num.length - 2]) {
                ++count;
            }
            for (int i = 1; i < num.length - 1; i++) {
                if (num[i - 1] > num[i] || num[i] > num[i + 1]) {
                    ++count;
                    num[i] = num[i - 1];
                }
                if (count > 1) {
                    break;
                }
            }
            if (count > 1) {
                System.out.println("0");
            } else {
                System.out.println("1");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[100];
        int[] y = new int[100];
        int maxX = sc.nextInt();
        int maxY = sc.nextInt();
        int minX = sc.nextInt();
        int minY = sc.nextInt();
        int flag = 0;
        while (true) {
            int i = 0;
            int j = 0;
            while (x[i] != 0 && y[i] != 0) {
                if (x[i] == 0 && y[i] == 0) {
                    flag++;
                    break;
                }
                flag = 0;
                i++;
            }
            if (flag == 2)
                break;
            maxX = x[0];
            maxY = y[0];
            minX = x[0];
            minY = y[0];
            for (j = 1; j < i; j++) {
                if (x[j] > maxX)
                    maxX = x[j];
                if (x[j] < minX)
                    minX = x[j];
                if (y[j] < maxY)
                    maxY = y[j];
                if (y[j] < minY)
                    minY = y[j];
            }
            System.out.print(minX);
            System.out.print(minY);
            System.out.print(maxX);
            System.out.print(maxY);
        }
    }

}
