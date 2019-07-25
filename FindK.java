package daily;

/**
 * Author: Sweetie77
 * Created: 2019/7/21
 */
public class FindK {
    /**
     * 利用快排的思想
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[]a,int n, int K){
        return findKth(a,0,n-1,K);
    }
    public int findKth(int[]a, int low, int high, int K){
        int part = partation(a,low,high);
        if(K == part - low +1)return a[part];
        else if (K>part-low+1) return findKth(a,part+1,high,K-part+low-1);
        else return findKth(a,low,part-1,K);
    }

    private int partation(int[] a, int low, int high) {
        int key = a[low];
        while(low < high){
            while(low < high && a[high] <= key) high--;
            a[low] = a[high];
            while (low < high & a[low]>=key)low--;
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

}
