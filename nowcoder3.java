package search;

import java.util.Arrays;

/**
 * Author: Sweetie77
 * Created: 2019/4/15
 */
public class nowcoder3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 已知前序和中序, 重建树
     * 先求出根结点
     * 将根结点带入到中序遍历序列中求出右子树的中序遍历序列
     * 通过左右子树中的中序序列元素集合带入前序遍历序列可以求出左右子树的前序序列
     * 左右子树的前序序列的第一个元素分别是根结点的左右儿子
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre != null && in != null) {
            TreeNode node = new TreeNode(pre[0]);
            for (int i = 0; i < in.length; i++) {
                if (pre[0] == in[i]) {
                    node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                    node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                }
            }
            return node;
        }
        return null;
    }

    private void Mirror(TreeNode root) {
        TreeNode tmp = null;
        if (root != null) {
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null) {
                Mirror(root.left);
            }
            if (root.right != null) {
                Mirror(root.right);
            }
        }
    }

    //输入两棵树AB, 判断B是不是A的子结构, 约定空树不是任意一个树的子结构
    private boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当1和2都不为空时才进行比较, 否则直接返回false
        if (root1 != null && root2 != null) {
            //如果找到了对应的t2的根结点的点
            if (root1.val == root2.val) {
                //以这个结点为起点判断是否包含t2
                result = doesTree1HavaTree2(root1, root2);
            }
            //如果找不到,那么就去root的左儿子当作起点, 去判断是否包含t2
            if (!result) {
                result = HasSubtree(root1.left,root2);
            }
            //如果还是找不到, 那么就去root的右子树, 当作起点, 去判断是否包含t2
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    private boolean doesTree1HavaTree2(TreeNode t1, TreeNode t2) {
        //如果t2已经遍历完了都能对应的上, 那就返回true
        if (t2 == null) {
            return true;
        }
        //如果t2没有遍历完, t1遍历完了, 返回false
        if (t1 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return false;
        }
        return doesTree1HavaTree2(t1.left, t2.left) && doesTree1HavaTree2(t1.right, t2.right);
    }
}
