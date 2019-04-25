package search;


import java.util.Arrays;

/**
 * Author: Sweetie77
 * Created: 2019/4/25
 */


public class HeapMain {
    /**
     * 1. 向下调整(堆化)
     * 必须满足可以向下调整的前提 : 只有一个位置不满足堆
     *
     * @param tree  看成完全二叉树的数组
     * @param index 要调整位置的下标
     */

    private static void heapify(int[] tree, int index) {
        int left = 2 * index + 1;
        if (left >= tree.length) {
            return;
        }
        /**
         * 不是叶子结点, 意味着一定有左孩子, 不一定有右孩子
         * 2. 找到最大的一个孩子
         *    1. 没有右孩子 左孩子
         *    2. 有右孩子
         *         1. 左边大  左孩子
         *         2. 右边大  右孩子
         */
        int right = 2 * index + 2;
        int max = left;
        if (right < tree.length && tree[right] > tree[left]) {
            max = right;

        }
        /**
         * 3. 和根的值进行比较
         * 如果根的值比较大, 满足堆的性质, 不需要调整
         * 否则, 交换数组中两个下标的值, 继续以max作为下标继续向下调整
         *
         */
        if (tree[index] >= tree[max]) {
            return;
        }
        //根的值比较, 交换
        int t = tree[index];
        tree[index] = tree[max];
        tree[max] = t;

        heapify(tree, max);
    }

    private static void adjustDown(int[] array, int index) {
        int min = 2 * index + 1;
        while (min < array.length) {
            if (min + 1 < array.length && array[min + 1] < array[min]) {
                min += 1;
            }
            if (array[index] <= array[min]) {
                break;
            }
            int t = array[min];
            array[min] = array[index];
            array[index] = t;


            index = min;
            min = 2 * index + 1;
        }
    }

    private static void adjustUp(int[] array, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] >= array[index]) {
                break;
            }
            int t = array[parent];
            array[parent] = array[index];
            array[index] = t;

            index = parent;
        }
    }

    private static void createHeap(int[] array) {
        //从最后一个非叶子结点开始, 一路向下调整到根的位置
        //[(array.length - 2)/2 ,0]
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapify(array, i);
        }
    }

    private static void selectSortRecusion(int[] array, int size) {
        int max = 0;
        for (int i = 1; i < size; i++) {
        }
    }

    //直接选择
    private static void selectSort(int[] array) {
        //每次选一个最大的数, 放到无序部分的最后
        //需要选n次或者n-1次
        int i;
        for (i = 0; i < array.length; i++) {
            //无序: [0, array.length-i)
            //有序: [array.length-i, array.length]
            //在无序部分选一个最大的数, 找出其下标
            int max = 0;//最大数的下标
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        adjustDown(array, 0);
        for (int item : array) {
            System.out.print(item);
        }
        System.out.println();

        int[] array2 = {1, 5, 3, 8, 7, 6};
        createHeap(array2);
        for (int item : array2) {
            System.out.print(item);
        }

        System.out.println();

        int[] array3 = {9,1,2,5,7,4,8,6,3,5};
        selectSort(array3);
        for (int item : array3) {
            System.out.print(item);
        }
    }

}
