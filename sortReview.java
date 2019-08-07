package com.tang;

import java.util.Arrays;

/**
 * Author: Sweetie77
 * Created: 2019/8/7
 */
public class sortReview {
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }


    public static void shell(int[] array) {
        int gap = array.length;
        while (true) {
            gap = gap / 3 + 1;
            insertSortWithGap(array, gap);
            if (gap == 1) break;
        }
    }

    private static void insertSortWithGap(int[] array, int gap) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - gap;
            for (; j >= 0 && key < array[j]; j = j - gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }


    public static void selectSort(int[] array) {
        //每次选择一个最小的插到无序部分的第一个
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j--) {
                if (array[j] < array[min])
                    min = j;
            }
            int t = array[min];
            array[min] = array[i];
            array[i] = t;
        }
    }


    private static void heapSort(int[] array) {

    }


    private static void bubbleSort(int[] array) {

    }

    public static void main(String[] args) {
        int[] array = {9, 3, 1, 5, 2, 4, 3, 8, 7, 6};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
