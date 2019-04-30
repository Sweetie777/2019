package Sort;

import java.util.Arrays;

/**
 * Author: Sweetie77
 * Created: 2019/4/30
 */
public class Partition {
    private static int partition1(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = array[right];
        while (begin < end) {
            while (begin < end && array[begin] <= pivot) {
                begin++;
            }
            // array[begin] > pivot
            while (begin < end && array[end] >= pivot) {
                end--;
            }
            // array[end] < pivot
            swap(array, begin, end);
        }
        swap(array, begin, right);
        return begin;
    }

    private static int partition2(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = array[right];
        while (begin < end) {
            while (begin < end && array[begin] <= pivot) {
                begin++;
            }

            array[end] = array[begin];
            while (begin < end && array[end] >= pivot) {
                end--;
            }
            array[begin] = array[end];
        }
        array[begin] = pivot;
        return begin;
    }

    private static int partition3(int[] array, int left, int right) {
        int d = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {
                swap(array, d, i);
                d++;
            }
        }

        swap(array, d, right);
        return d;
    }
    private static void swap(int [] array, int i,int j){
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 1, 9, 7};
        partition1(array);
        System.out.println(Arrays.toString(array));
    }
}
