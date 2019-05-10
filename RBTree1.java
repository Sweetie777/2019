package Tree;

/**
 * Author: Sweetie77
 * Created: 2019/5/6
 */
public class RBTree<T extends Comparable<T>> {
    private RBTNode<T> mRoot; //根结点

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable<T>> {
        boolean color;   //颜色
        T key;           //关键字(键值)
        RBTNode<T> left; //左孩子
        RBTNode<T> right;//右孩子
        RBTNode<T> parent;//父结点

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;

        }
    }

    /**
     * 对红黑树的结点x进行左旋转
     * <p>
     * 左旋转示意图(对结点x进行左旋)
     * px                    px
     * /                     /
     * x                     y
     * / \       ->          / \
     * 1x  y                 x  ry
     * / \               / \
     * 1y ry            1x 1y
     */
    private void leftRotate(RBTNode<T> x) {
        //设置x的右孩子为y
        RBTNode<T> y = x.right;
        //将y的左孩子设为x的右孩子
        //如果y的左孩子非空, 将x设为y的左孩子的父亲
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        //将 x的父亲 设为 y的父亲
        y.parent = x.parent;
        if (x.parent == null) {
            this.mRoot = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        //将x设为y的左孩子
        y.left = x;
        //将x的父结点设为y
        x.parent = y;
    }

    /**
     * 对红黑树的结点y进行右旋转
     * 右旋转示意图(对结点y进行左旋)
     *
     * @param y py             py
     *          /              /
     *          y              x
     *          / \     ->     / \
     *          x  ry          1x  y
     *          / \                / \
     *          1x rx              rx ry
     */
    private void rightRotate(RBTNode<T> y) {
        //设置x是当前结点的左孩子
        RBTNode<T> x = y.left;
        //将 x的右孩子 设为 y的左孩子
        //如果 x的右孩子 不为空的话, 将 y 设为 x的右孩子的父亲
        y.left = x.right;
        if (x.right == null) {
            x.right.parent = y;
        }
        //将 y的父亲 设为 x的父亲
        x.parent = y.parent;

        if (y.parent == null) {
            this.mRoot = x;
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
        }
        //将y设为 x的右孩子
        x.right = y;
        //将y的父结点 设为 x
        y.parent = x;
    }

    /**
     * 将结点插入到红黑树中
     *
     * @param node 插入的结点
     */

    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;
        //1.将红黑树当作一颗二叉查找树, 将结点添加到二叉查找树中
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.right = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        } else {
            this.mRoot = node;
        }
        //2.设置结点的颜色为红色
        node.color = RED;
        //3.将它重新修正为一颗二叉查找树
        insertFixUp(node);
    }

    /**
     * 新建结点(key) 并将其插入到红黑树中
     *
     * @param key 插入结点的键值
     */
    public void insert(T key) {
        RBTNode<T> node = new RBTNode<T>(key, BLACK, null, null, null);
        //如果新建结点失败, 则返回
        if (node != null) {
            insert(node);
        }

    }

    /**
     * 红黑树插入修正函数
     *
     * 在向红黑树中插入结点之后(失去平衡), 再调用该函数
     * 目的是将它重新塑造成一颗红黑树
     * @param node 插入的结点
     *
     */
    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent;
        RBTNode<T> gparent;
        //若 父结点存在, 并且父结点的颜色是红色
        if()
    }

    private void parentOf(RBTNode<T> node) {
    }
}
