package search;

import javax.xml.soap.Node;
import java.util.Arrays;

/**
 * Author: Sweetie77
 * Created: 2019/4/18
 */
public class solution {
    class Node {
        char value;
        Node left;
        Node right;
    }

    class RV {
        Node node;
        int used;
    }

    RV createTree(char[] preOrder) {
        if (preOrder.length == null) {
            return new CV(null, 0);
        } else if (preOrder[0] == '#') {
            return new CV(null, 1);

        } else {        //1.preOrder[0] 位置就是根的值, 拿根的值创建根结点
            char rootValue = preOrder[0];
            Node root = new Node(rootValue);

            //2. 利用preOrder,找到左子树的前序遍历数组, 去掉第一个值
            char[] leftPreOrder = new char[preOrder.length - 1];
            leftPreOrder = Arrays.copyOfRange(preOrder, 1, preOrder.length);

            //3. 递归调用, 返回两个值, 创建左子树, 左使用的个数
            RV leftReturn createTree(leftPreOrder);
            //leftReturn.node;//创建号得左子树得根结点
            //leftReturn.used;//创建左子树过程中用得个数

            //4. 利用preOrder, 找到右子树t的前序遍历数组, 去掉第一个值, 去掉左用的值\
            char[] rightPreOrder = new char[preOrder.length - 1 - leftReturn.used];
            rightPreOrder = Arrays.copyOfRange(preOrder, 1, preOrder.length);

            //5.递归调用返回两个值, 创建右子树, 右使用的个数
            //6. 把根, 左, 右关联在一起
            //7. 返回创建好的树和使用的个数

            //终止条件: 1)preOrder.length == 0 或者 preOrder.length[0] == '#' 先判断前者再判断后者, 否则会数组越界
        }
    }
}
