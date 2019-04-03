package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/3
 */

public interface IArrayList {
    // 增 / 删

    /**
     * 把 item 插入到线性表的前面
     * @param item 要插入的数据
     */
    void pushFront(int item);

    /**
     * 把 item 插入到线性表的最后
     * @param item
     */
    void pushBack(int item);

    /**
     * 把 item 插入到 index 下标位置处, index 后的数据后移
     * @param item
     * @param index
     */
    void add(int item, int index);

    /**
     * 删除前面的数据
     */
    void popFront();

    /**
     * 删除最后的数据
     */
    void popBack();

    /**
     * 删除 index 处的数据，index 后的数据前移
     * @param index
     */
    void remove(int index);

    // 改 / 插
}
