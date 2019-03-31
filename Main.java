package search;

import java.util.Random;

/**
 * Author: Sweetie77
 * Created: 2019/3/31
 */
public class Main {
    //O(n)
    private static int search(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;

            }
        }
        return -1;
    }

    //二分查找
    //在数组中查找 数组是有序的
    //[left,right)
    private static int binarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int m = left + (right - left) / 2;//因为l+r超过int会溢出,等价于left+(right-left)>>1
            if (value == array[m]) {
                return m;
            } else if (value < array[m]) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return -1;
    }
    //O(log(n))
    //二分查找
    //[left,right]
    private static  int binarySearch1(int[] array,int value){
        int left = 0;
        int right = array.length;
        //[10,10]区间还有一个数, 所以还要继续查找
        while(left<=right){
            int m =left + (right - left)>>1;
            if (value == array[m]) {
                return m;
            } else if (value < array[m]) {
                right = m - 1;
            } else {
                left = m + 1;
            }

        }
        return -1;
    }

    //
    private static void bubbleSort(int[]array){
        // 外部的循环表示的是，冒泡的次数
        // 一次冒泡可以解决一个数的问题
        // 一共需要 array.length
        // 更优化的方式是 array.length - 1
        for(int i = 0;i<array.length;i++){
            //每次冒泡前,假设数组已经有序
            boolean sorted = true;
            //一次冒泡的过程,保证最大的数被推到最后去
            for (int j = 0; j <= array.length - 2 - i; j++) {
                // 保证相邻的两个数，最大的在后面
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;

                    sorted = false;
                }
            }

            // 如果过程一次交换都没发生过，假设有序成立
            if (sorted == true) {
                break;
            }
        }
    }
    private static int[] createArray(int size) {
        Random rand = new Random(20190330);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }

        return array;
    }

    private static void test(int size) {
        System.out.format("数据规模: %d 万\n", size / 10000);
        int[] array = createArray(size);
        long s, e;
        double ms;

        s = System.nanoTime();
        search(array, size + 1);
        e = System.nanoTime();
        ms = (e - s) * 1.0 / 1000 / 1000;
        System.out.format("遍历查找耗时: %.3f 毫秒\n", ms);

        s = System.nanoTime();
        bubbleSort(array);
        e = System.nanoTime();
        ms = (e - s) * 1.0 / 1000 / 1000;
        System.out.format("冒泡排序耗时: %.3f 毫秒\n", ms);

        s = System.nanoTime();
        binarySearch(array, size + 1);
        e = System.nanoTime();
        ms = (e - s) * 1.0 / 1000 / 1000;
        System.out.format("二分查找耗时: %.3f 毫秒\n", ms);
    }

    public static void main(String[] args) {
        
    }
}
