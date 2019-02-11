package com.sweetie77.IO.feature;

/**
 * Author: Sweetie77
 * Created: 2018/12/9
 */
public class TestFeature {
    public static int add(int[] data) {
        if (data == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }

    public static int add1(int... data) {
        if (data == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];

        }
        return sum;
    }

    public static void print(String message, String... args) {


    }


    public static void main(String[] args) {

    }
}
