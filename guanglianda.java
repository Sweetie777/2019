package com.tang;

/**
 * Author: Sweetie77
 * Created: 2019/9/9
 */
public class guanglianda {
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A) {
        vector<vector<int>> B;
        B = A;
        for (int i = 0; i < A.size(); i++)
        {
            int k = 0;
            for (int j = A[0].size()-1; j>=0; j--)
            {
                B[i][k] = !A[i][j];
                k++;
            }
        }
        return B;
    }


    //求二叉树的最大深度
    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value=data;
        }
    }
    //递归实现
    int maxDeath(Node root){
        if(root==null){
            return 0;
        }
        int left = maxDeath(root.left);
        int right = maxDeath(root.right);
        return Math.max(left,right) + 1;
    }



    public Node detectCycle() {

        Node fast = this.head;

        Node slow = this.head;

        //判断是否有环，若有环则fast = slow，退出循环

        while (fast != null && fast.next.next != null) {

            fast = fast.next.next;

            slow = slow.next;

            //每一次变化，都需要进行判断

            if (fast == slow) {

                break;

            }

        }

        //若无环返回空

        if (fast == null || fast.next == null) {

            return null;

        }

        slow = this.head;

        //当fast和slow没相遇时，fast和slow同时往后移

        while (fast != slow) {

            fast = fast.next;

            slow = slow.next;

        }

        return slow;

    }

    public void area(int r){
        if(r <= 1) System.out.println(0);
        int count = 0;
        for(int i = 1;i <= r;i++)
            for(int j = 1;j <= r;j++){
                double distance = Math.sqrt(i * i + j * j);
                if(distance <= r) count++;
            }
        System.out.println(count * 4);
    }

}
