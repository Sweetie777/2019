package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/26
 */
public class CreateHeap {
    private T[] heap;//用来存储堆元素的数组
    private int lastIndex;//最后一个元素的索引
    private static final int DEFAULT_INITIAL_CAPACITY = 25;
    public void add(T newEntry) {
        lastIndex++;
        if(lastIndex >= heap.length)
            doubleArray();//若堆空间不足，则堆大小加倍
        int newIndex = lastIndex;//从最后一个元素开始逐渐向上与父结点比较
        int parentIndex = newIndex / 2;
        heap[0] = newEntry;//哨兵
        while(newEntry.compareTo(heap[parentIndex]) > 0){
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        heap[newIndex] = newEntry;
    }
    /*
     * @Task:将树根为rootIndex的半堆调整为新的堆，半堆：树的左右子树都是堆
     * @param rootIndex 以rootIndex为根的子树
     */
    private void reheap(int rootIndex){
        boolean done = false;//标记堆调整是否完成
        T orphan = heap[rootIndex];
        int largeChildIndex = 2 * rootIndex;//默认左孩子的值较大
        //堆调整基于以largeChildIndex为根的子树进行
        while(!done && (largeChildIndex <= lastIndex)){
            //largeChildIndex 标记rootIndex的左右孩子中较大的孩子
            int leftChildIndex = largeChildIndex;//默认左孩子的值较大
            int rightChildIndex = leftChildIndex + 1;
            //右孩子也存在,比较左右孩子
            if(rightChildIndex <= lastIndex && (heap[largeChildIndex].compareTo(heap[rightChildIndex] )< 0))
                largeChildIndex = rightChildIndex;
            //    System.out.println(heap[largeChildIndex]);//这里有问题。。使用构造函数创建时reheap。。。。。
            if(orphan.compareTo(heap[largeChildIndex]) < 0){
                heap[rootIndex] = heap[largeChildIndex];
                rootIndex = largeChildIndex;
                largeChildIndex = 2 * rootIndex ;//总是默认左孩子的值较大
            }
            else//以rootIndex为根的子树已经构成堆了
                done = true;
        }
        heap[rootIndex] = orphan;
    }

}
