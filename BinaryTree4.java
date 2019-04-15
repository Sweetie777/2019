package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/14
 */
public class BinaryTree4 {
    private static class TreeNode {
        char value;
        TreeNode left;
        TreeNode right;

        TreeNode(char v) {
            this.value = v;
        }
    }

    private static TreeNode createTestTree() {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;

        return a;
    }


    private static int count = 0;

    // 用遍历的思想解决这个问题
    private static void countByTraversal(TreeNode root) {
        if (root != null) {
            countByTraversal(root.left);
            countByTraversal(root.right);
            count++;
        }
    }

    //求结点个数
    private int numNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return numNode(root.left) + numNode(root.right) + 1;
    }

    //求叶子结点个数
    private  int numLeefNode(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return numLeefNode(root.left) +numLeefNode(root.right);
    }


    //求第k层中结点的个数
    private int numKLevelNode(TreeNode root, int k){
        if(root == null || k<1 ){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return numKLevelNode(root.left,k-1)+numKLevelNode(root.right,k-1);
    }
}
