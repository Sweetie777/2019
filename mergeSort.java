package Sort;

/**
 * Author: Sweetie77
 * Created: 2019/4/27
 */
public class quickSort {
    private static void merge(int[] array, int low, int mid, int high, int extra) {
        int[] extra = new int[high - low];
        int i = low; //遍历[low, mid)
        int j = mid; //遍历[mid, high)
        int x = 0;    //遍历
        while (i < mid && j < high) {
            if (array[i] <= array[j]) {
                extra[x++] = array[i++];
            } else {
                extra[x++] = array[j++];
            }
        }
        while (i < mid) {
            extra[x++] = array[i++];
        }
        while (i < high) {
            extra[x++] = array[j++];
        }
        for (int k = low; k < high; k++) {
            array[k] = extra[k - low];//减去下标

        }
    }

    private static void mergeSortInner(int[] array, int low, int high, int extra) {
        //array[low,high)  [3,4)
        if (low == high - 1) {
            return;
        }
        if (low >= high) {
            return;
        }
        //array[low,high]
        //1.平均切分
        int mid = low + (high - low) / 2;
        //[low ,mid)  + [mid, right)
        //2. 分治算法处理两个小区间
        mergeSortInner(array, low, mid, extra);
        mergeSortInner(array, mid, high, extra);

        merge(array, low, mid, high, extra);
    }

    private static void mergeSort(int[] array, int extra) {
        int[] extra = new int[array.length];
        mergeSortInner(array, 0, array.length, extra);
    }
}
