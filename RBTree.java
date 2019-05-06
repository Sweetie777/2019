package Tree;

/**
 * Author: Sweetie77
 * Created: 2019/5/6
 */
public class RBTree < T extends Comparable<T>> {
    private RBTNode<T> mRoot; //根结点

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBTNode <T extends Comparable<T>>{
        boolean color;   //颜色
        T key;           //关键字(键值)
        RBTNode<T> left; //左孩子
        RBTNode<T> right;//右孩子
        RBTNode<T> parent;//父结点

        public RBTNode(T key, boolean color, RBTNode<T>parent,RBTNode<T> left,RBTNode<T> right){
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;

        }
    }
    /**
     * 对红黑树的结点x进行左旋转
     *
     * 左旋转示意图(对结点x进行左旋)
     *           px                    px
     *          /                     /
     *         x                     y
     *        / \       ->          / \
     *       1x  y                 x  ry
     *          / \               / \
     *         1y ry            1x 1y
     */
    private void leftRotate(RBTNode<T> x){
        //设置x的右孩子为y
        RBTNode<T> y = x.right;
        //将y的左孩子设为x的右孩子
        //如果y的左孩子非空, 将x设为y的左孩子的父亲
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }
        //将 x的父亲 设为 y的父亲
        y.parent = x.parent;
        if(x.parent == null){
            this.mRoot = y;
        }else{
            if(x.parent.left == x){
                x.parent.left = y;
            }else{
                x.parent.right = y;
            }
        }
        //将x设为y的左孩子
        y.left = x;
        //将x的父结点设为y
        x.parent = y;
    }
}
