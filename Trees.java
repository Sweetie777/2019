package tree;

import java.util.*;

/**
 * Author: Sweetie77
 * Created: 2019/8/23
 */
public class Trees {
    public static void levelOrder(TreeNode root) {
        //用到队列
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.println(front.val);

            if (front.left != null) {

            }
        }
    }


    /**
     * 面试题 前序+中序构建二叉树
     * <p>
     * 1. 在前序中找到根, 在中序中找到根所在的下标, 进而得到左右子树的长度
     */
    TreeNode buildTree(List<Integer> pre, List<Integer> in) {
        if(pre.size() == 0){
            return null;
        }
        int rootValue = pre.get(0);
        int leftCount = in.indexOf(rootValue);
        int rightCount = pre.size() - leftCount - 1;

        List<Integer> leftPre = pre.subList(1, 1 + leftCount);
        List<Integer> leftIn = in.subList(0, leftCount);
        List<Integer> rightPre = pre.subList(1 + leftCount, pre.size());
        List<Integer> rightIn = in.subList(leftCount + 1, in.size());


        TreeNode root = new TreeNode();
        root.val = rootValue;
        root.left = buildTree(leftPre,leftIn);
        root.right = buildTree(rightPre,rightIn);

        return null;
    }

    TreeNode buildTree2(List<Integer> in, List<Integer> post) {
        if(in.size() == 0){
            return null;
        }
        int rootValue = post.get(post.size()-1);
        int leftCount = in.indexOf(rootValue);//左子树结点个数
        int rightCount = post.size() - leftCount -1;

        List<Integer> leftIn = in.subList(0,leftCount);
        List<Integer> leftPost = post.subList(0,leftCount);
        List<Integer> rightIn = in.subList(leftCount+1,in.size());
        List<Integer> rightPost= post.subList(leftCount,post.size());

        TreeNode root = new TreeNode();
        root.val = rootValue;
        root.left = buildTree(leftIn,leftPost);
        root.right = buildTree(rightIn,rightPost);

        return null;
    }
}
