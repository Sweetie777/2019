package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: Sweetie77
 * Created: 2019/4/14
 */
public class BinaryTree {

    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char x) {
            this.val = x;
        }
    }

    /*
     * 递归实现
     */
    private static void preorderTraversal(TreeNode root) {
        if (root != null) {
            // 根 左子树的前序遍历 右子树的前序遍历
            System.out.print(root.val + " ");

            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    private static void inorderTraversal(TreeNode root) {
        if (root != null) {
            // 左子树的中序遍历 根 右子树的中序遍历
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    private static void postorderTraversal(TreeNode root){
        if (root != null) {
            // 左子树的后序遍历 右子树的后序遍历 根
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static TreeNode createTestTree() {
        TreeNode n1 = new TreeNode('A');
        TreeNode n2 = new TreeNode('B');
        TreeNode n3 = new TreeNode('C');
        TreeNode n4 = new TreeNode('D');
        TreeNode n5 = new TreeNode('E');
        TreeNode n6 = new TreeNode('F');
        TreeNode n7 = new TreeNode('G');
        TreeNode n8 = new TreeNode('H');

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.right = n8;

        return n1;
    }

    public static void main(String[] args) {
        TreeNode root = createTestTree();
        preorderTraversal(root);
        System.out.println();
        inorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
        System.out.println();

        //System.out.println("二叉树高度: " + height(root));
    }
}
