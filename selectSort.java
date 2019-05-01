package Sort;

import java.util.Arrays;

/**
 * Author: Sweetie77
 * Created: 2019/5/1
 */
public class selectSort {
    // 选择排序
    public static void selectSort(int[] array)
    {
        // 每次选择一个最小的放到无序部分的最开始位置
        for (int i = 0; i < array.length; i++) {
            // 有序 [0, i)
            // 无序 [i, array.length)
            int min = i;    // 记录最终最小数所在的下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            // 最终交换一次
            swap(array, min, i);
        }
    }
    public static void swap(int[] array, int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        int[] array = {2,1,5,4,8,2,9};
        selectSort(array);
        System.out.println(Arrays.toString(args));
    }
}
