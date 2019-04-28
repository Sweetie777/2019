package List;

/**
 * Author: Sweetie77
 * Created: 2019/4/28
 */

class Heap {
    private int[] array;
    int size;

    Heap() {
        this(new int[0]);
    }

    Heap(int[] array) {
        this.array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
        this.size = array.length;

        createHeap(this.array, this.size);
    }

    /**
     * 返回堆里的最值
     * @return
     */
    public int top() {
        return array[0];
    }

    public int pop() {
        int v = array[0];
        array[0] = array[size - 1];
        size--;

        heapify(array, size, 0);

        return v;
    }

    private void adjustUp(int[] array, int size, int index) {
        /**
         * 1. array[index] <= array[(index - 1) / 2]
         * 2. index == 0
         */
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] >= array[index]) {
                break;
            }

            int t = array[parent];
            array[parent] = array[index];
            array[index] = t;

            // 继续向上调整
            index = parent;
        }
    }

    public void push(int v) {
        array[size++] = v;

        adjustUp(array, size, size - 1);
    }

    /**
     * 大堆
     * 向下调整（堆化）
     * 必须满足可以向下调整的前提：只有一个位置不满足堆
     * @param tree  看成完全二叉树的数组
     * @param index 要调整位置的下标
     */
    private void heapify(int[] tree, int size, int index) {
        /**
         * 1. 判断 index 位置是不是叶子结点
         *    完全二叉树，只要判断有没有左孩子
         *    转化成数组下标越界的问题去判断
         */
        int left = 2 * index + 1;
        if (left >= size) {
            return;
        }

        /**
         * 不是叶子结点，意味一定有左孩子，但不一定有右孩子
         * 2. 找到最大的一个孩子
         *      1. 没有右孩子    左孩子
         *      2. 有右孩子
         *          1. 左边大    左孩子
         *          1. 右边大    右孩子
         */
        int right = 2 * index + 2;
        int max = left;
        if (right < size && tree[right] > tree[left]) {
            max = right;
        }

        /**
         * 3. 和根的值进行比较
         * 如果根的值比较大，满足堆的性质，不需要调整
         * 否则，交换数组中两个下标的值
         *       并且，继续以 max 作为下标，进行向下调整
         */
        if (tree[index] >= tree[max]) {
            return;
        }

        // 根的值比较小，先交换
        int t = tree[index];
        tree[index] = tree[max];
        tree[max] = t;

        // 继续向下调整
        heapify(tree, size, max);
    }

    private void adjustDown(int[] array, int size, int index) {
        int min = 2 * index + 1;
        while (min < size) {
            if (min + 1 < size && array[min + 1] < array[min]) {
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

    /**
     * 细算 O(n)
     * 粗略 O(n * log(n))
     * @param array
     */
    private void createHeap(int[] array, int size) {
        // 从最后一个非叶子结点的下标开始，一路向下调整至根位置
        // [(array.length - 2) / 2, 0 ]

        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(array, size, i);
        }
    }

    public int getSize() {
        return size;
    }
}