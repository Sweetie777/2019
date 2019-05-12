package Tree;

/**
 * Author: Sweetie77
 * Created: 2019/5/12
 */
public class RBTree2 {
    /**
     * 红黑树插入修正函数
     *
     * 在向红黑树中插入结点之后(失去平衡), 再调用该函数
     * 目的是将它重新塑造成一颗红黑树
     * @param node 插入的结点
     *
     */
    private void insertFixUp(Tree.RBTree.RBTNode<T> node) {
        Tree.RBTree.RBTNode<T> parent;
        Tree.RBTree.RBTNode<T> gparent;
        //若 父结点存在, 并且父结点的颜色是红色
        while(((parent = parentOf(node))!= null) && isRED(parent)){
            gparent = parentOf(parent);
            //若父结点是祖父结点的左孩子
            if(parent == gparent.left){
                Tree.RBTree.RBTNode<T> uncle = gparent.right;
                if((uncle != null) && isRED(uncle)){
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                //case2 条件 : 叔叔是黑色, 且当前结点是右孩子
                if(parent.right == node){
                    Tree.RBTree.RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                //case3条件 : 叔叔是黑色, 且当前结点是左孩子
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            }else{
                //case1 条件 : 叔叔结点是红色
                Tree.RBTree.RBTNode<T> uncle = gparent.left;
                if((uncle != null) && isRED(uncle)){
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                //case2条件 : 叔叔是黑色, 且当前结点是左孩子
                if(parent.left == node){
                    Tree.RBTree.RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                //case3 条件 : 叔叔是黑色, 且当前结点是右孩子
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(this.mRoot);
    }

    private void setRed(Tree.RBTree<T>.RBTNode<T> gparent) {
        return;
    }

    private void setBlack(Tree.RBTree<T>.RBTNode<T> mRoot) {
        return ;
    }

    private boolean isRED(Tree.RBTree.RBTNode<T> parent) {
        return true;
    }

    private Tree.RBTree.RBTNode parentOf(Tree.RBTree.RBTNode<T> node) {
        return node;
    }


    /**
     * 删除结点node, 并返回被删除的结点
     * @param node 删除的结点
     */
    private void remove(Tree.RBTree.RBTNode<T> node){
        Tree.RBTree.RBTNode<T> child,parent;
        boolean color;
        //被删除的结点的 左右孩子都不为空 的情况
        if((node.left!= null) && (node.right !=null)){
            //被删结点的后继结点(取代结点)
            //用它来取代被删结点的位置, 然后再将被删结点 全掉
            Tree.RBTree.RBTNode<T> replace = node;
            //获取后继结点
            replace = replace.right;
            while(replace.left !=null){
                replace = replace.left;
            }

            //node结点不是根结点(只有根结点不存在父结点)
            if(parentOf(node) != null){
                if(parentOf(node).left == node){
                    parentOf(node).left = replace;
                }else{
                    parentOf(node).right = replace;
                }
            }else{
                //node结点是根结点, 更新根结点
                this.mRoot = replace;
            }
            //child 是取代结点 的右孩子, 也是需要 调整的结点
            //取代结点 肯定不存在左孩子, 因为它是一个后继结点
            child = replace.right;
            parent = parentOf(replace);
            //保存 取代结点 的颜色
            color = colorOf(replace);

            //被删除结点 是 它的后记结点 的父结点
            if(parent == node){
                parent = replace;
            }else{
                if(child != null){
                    setParent(child,parent);
                }
                parent.left = child;

                replace.right = node.right;
                setParent(node.right,replace);
            }

            replace.parent = node.right;
            replace.color = node.color;
            replace.left = node.left;
            replace.left.parent = replace;

            if(color == BLACK){
                removeFixUp(child,parent);
            }
            node = null;
            return;
        }
        if(node.left != null){
            child = node.left;
        }else{
            child = node.right;
        }

        parent = node.right;
        //保存 取代结点 的颜色
        color = node.color;

        if(child!= null){
            child.parent = parent;
        }
        if(parent != null){
            if(parent.left == node)
                parent.left = child;
            else
                parent.right = child;
        }else{
            this.mRoot = child;
        }

        if(color == BLACK)
            removeFixUp(child,parent);
        node = null;
    }

    /**
     * 删除结点z, 并返回被删除的结点
     * @param key
     * tree 红黑树的根结点
     * z 删除的结点
     */
    public void remove(T key){
        Tree.RBTree.RBTNode<T> node;
        if((node  = search(this.mRoot,key)) != null){
            remove(node);
        }
    }



    private Tree.RBTree.RBTNode search(Tree.RBTree.RBTNode<T> mRoot, T key) {
        return mRoot;
    }

    private void removeFixUp(Tree.RBTree<T>.RBTNode<T> child, Tree.RBTree<T>.RBTNode<T> parent) {
    }

    private void setParent(Tree.RBTree<T>.RBTNode<T> child, Tree.RBTree<T>.RBTNode<T> parent) {
        return ;
    }

    private boolean colorOf(Tree.RBTree<T>.RBTNode<T> replace) {
        return true;
    }
}

}
