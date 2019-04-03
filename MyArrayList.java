package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/3
 */

public class MyArrayList implements IArrayList {
    private int[] array;    // 保存数据的空间
    private int size;       // 保存有效数据个数

    MyArrayList(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    // O(n)
    @Override
    public void pushFront(int item) {
        ensureCapacity();
        // 将顺序中已有的数据后移一格
        for (int i = this.size; i >= 1; i--) {
            this.array[i] = this.array[i - 1];
        }

        this.array[0] = item;
        this.size++;
    }

    // O(1)
    @Override
    public void pushBack(int item) {
        ensureCapacity();
        this.array[this.size] = item;
        this.size++;
    }

    // O(n)
    @Override
    public void add(int item, int index) {
        if (index < 0 || index > this.size) {
            throw new Error();
        }

        ensureCapacity();

        // i 代表的是数据所在的下标
        for (int i = this.size - 1; i >= index; i--) {
            this.array[i + 1] = this.array[i];
        }

        /*
        // i 代表的循环的次数
        for (int i = 0; i < this.size - index; i++) {
            this.array[this.size - i]
                    = this.array[this.size - i - 1];
        }
        */

        this.array[index] = item;
        this.size++;
    }

    // O(n)
    @Override
    public void popFront() {
        if (this.size == 0) {
            throw new Error();
        }

        for (int i = 1; i < this.size; i++) {
            this.array[i - 1] = this.array[i];
        }

        /*
        for (int j = 0; j < this.size - 1; j++) {
            this.array[j] = this.array[j + 1];
        }
        */

        this.array[--this.size] = 0;
    }

    // O(1)
    @Override
    public void popBack() {
        if (this.size == 0) {
            throw new Error();
        }
        this.array[--this.size] = 0;
    }

    // O(n)
    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new Error();
        }

        if (this.size == 0) {
            throw new Error();
        }

        for (int i = index ; i <= this.size - 2; i++) {
            this.array[i] = this.array[i + 1];
        }

        //this.size--;
        this.array[--this.size] = 0;
    }

    // O(n)
    /**
     * 保证数组容量够用
     */
    private void ensureCapacity() {
        if (this.size < this.array.length) {
            return;
        }

        // 1. 找新房子，找原来的 2 倍大小
        int capacity = this.array.length * 2;
        int[] newArray = new int[capacity];

        // 2. 搬家
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }

        // 3. 去学校登基下新房子位置，退掉老房子
        this.array = newArray;
    }
}
