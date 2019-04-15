package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/14
 */
public class BinaryTree3 {
    public class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char x) {
            this.val = x;
        }
    }

    private int maxDepth(TreeNode root) {
        //1. 空树
        //2. 取左子树和右子树中较大的那个, 然后加1
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }


    //判断两棵树是否一样
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q != null && p != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    //判断一个树是否是另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return t == null;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    //判断一个树是否为二叉树
    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && q.val == p.val) {
            return isMirror(q.left, p.right) && isMirror(q.right, p.left);
        } else {
            return false;
        }
    }

    private boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }


    public static void main(String[] args) {

    }

}
