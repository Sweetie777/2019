package tree;

/**
 * Author: Sweetie77
 * Created: 2019/8/23
 */
public class InterView {
    //求二叉树最大深度
    private int maxDeath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeath(node.left);
        int right = maxDeath(node.right);
        return Math.max(left, right) + 1;
    }

    //求二叉树最小深度
    private int getMinDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.min(getMin(root.left),getMin(root.right))+1;
    }


}
