package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/22
 */
public class TreeStorage {

    private static boolean TextUtils;

    private static class BiTree {

    }

    public static class BiNode {
        public String data;
        public BiNode leftChild;
        public BiNode rightChild;
    }

    /**
     * 将二叉树的顺序存储结构转换为链式存储结构
     * @param  nodes 顺序存储结构数组
     * @return
     */
    public  static  final BiTree convertFromArray(String[] nodes){
        BiNode root = new BiNode();
        root.data = nodes[1];
        createBiTreeNode(root,nodes,1);
        return new BiTree(root);

    }

    private static BiNode createBiTreeNode(BiNode root, String[] nodes, int position) {
        if(position * 2 >= nodes.length){
            return root;
        }
        if(!TextUtils.isEmpty(nodes[position *2 ])){
            BiNode leftChild = new BiNode();
            leftChild.data = nodes[position *2];
            root.leftChild = leftChild;
            createBiTreeNode(root.leftChild,nodes,position *2);
        }
        if(!TextUtils.isEmpty(nodes[position *2 + 1])){
            BiNode rightChild = new BiNode();
            rightChild.data = nodes[position *2 +1];
            root.leftChild = rightChild;
            createBiTreeNode(root.leftChild,nodes,position *2);
        }
        return root;
    }
}
