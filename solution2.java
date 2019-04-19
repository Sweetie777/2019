import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 为了实现一个函数返回两个值的效果
 * 把两个不同的返回值打包到一个类里
 */
class CreateTreeReturnValue {
    /**
     * 创建好的二叉树的根结点
     */
    public Node returnRoot;
    /**
     * 使用的个数
     */
    public int used;

    CreateTreeReturnValue(Node returnRoot, int used) {
        this.returnRoot = returnRoot;
        this.used = used;
    }
}

public class Solution2 {
    private static CreateTreeReturnValue createTree(char[] preOrder) {
        if (preOrder.length == 0) {
            return new CreateTreeReturnValue(null, 0);
        }

        char rootValue = preOrder[0];
        if (rootValue == '#') {
            return new CreateTreeReturnValue(null, 1);
        }

        // 1. 根结点
        Node root = new Node(rootValue);

        // 2. 左子树，利用递归
        char[] leftPreOrder = new char[preOrder.length - 1];
        leftPreOrder = Arrays.copyOfRange(preOrder, 1, preOrder.length);
        CreateTreeReturnValue leftReturn
                = createTree(leftPreOrder);
        // 3. 右子树，利用递归
        // length - 根的长度 - 左子树的长度
        // length - 1 - leftReturn.used
        char[] rightPreOrder = new char[preOrder.length - 1 - leftReturn.used];
        rightPreOrder = Arrays.copyOfRange(preOrder, 1 + leftReturn.used, preOrder.length);
        CreateTreeReturnValue rightReturn
                = createTree(rightPreOrder);

        // 绑定左右子树和根
        root.left = leftReturn.returnRoot;
        root.right = rightReturn.returnRoot;

        // 创建好的树的根结点是 root
        // 使用的个数是
        //      根使用的 (1)
        //    + 左子树使用的 (leftReturn.used)
        //    + 右子树使用的 (rightReturn.used)
        return new CreateTreeReturnValue(
                root,
                1 + leftReturn.used + rightReturn.used
        );
    }


    /**
     * @param root 二叉树的根结点
     * @param v 要找的值
     * @return null 表示没找到，非 null 表示结点引用
     */
    private static Node find2(Node root, char v) {
        // 1. 空树的判断
        if (root == null) {
            return null;
        }

        // 肯定不是空树
        // 2. 比较根结点的值
        if (root.value == v) {
            return root;
        }

        // 根结点不是要找的结点
        // 3. 去左子树中查找
        Node left = find2(root.left, v);
        if (left != null) {
            return left;    // 返回左子树中找到的结点引用
        }

        // 左子树中没有找到
        // 4. 去右子树中查找
        return find2(root.right, v);
    }

    private static int find(char[] array, char v) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == v) {
                return i;
            }
        }

        return -1;
    }

    private static Node buildTree(char[] preorder, char[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        // 1. 根据前序，找到根的值，并且创建根结点
        char rootValue = preorder[0];
        Node root = new Node(rootValue);


        // 2. 在中序中找到根的值所在的下标
        int leftSize = find(inorder, rootValue);

        // 3. 切出左子树的前序 和 中序
        char[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        char[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);

        root.left = buildTree(leftPreorder, leftInorder);

        // 4. 切出右子树的前序 和 中序
        char[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
        char[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, preorder.length);

        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    static Node buildTree2(char[] inorder, char[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        char rootValue = postorder[postorder.length - 1];
        Node root = new Node(rootValue);
        int leftSize = find(inorder, rootValue);

        char[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
        char[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftSize);
        root.left = buildTree2(leftInorder, leftPostorder);

        char[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        char[] rightPostorder = Arrays.copyOfRange(postorder, leftSize, postorder.length - 1);
        root.right = buildTree2(rightInorder, rightPostorder);

        return root;
    }

    public static void main(String[] args) {
        char[] preorder = new char[] {
                'A', 'B', 'C', 'D', 'E'
        };

        char[] inorder = new char[] {
                'C', 'D', 'B', 'A', 'E'
        };

        char[] postorder = new char[] {
                'D', 'C', 'B', 'E', 'A'
        };

        Node root = buildTree(preorder, inorder);

        find2(root, 'E');

        root = buildTree2(inorder, postorder);

        find2(root, 'E');
    }
}
