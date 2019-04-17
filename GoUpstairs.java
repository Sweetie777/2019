package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/17
 */
public class GoUpstairs {
    public int countWays(int n) {
        // write code here
/*
在第一级台阶，从第一级到第一级有0种走法，f(1)=0
在第二级台阶，从第一级到第二级有1种走法，f(2)=1
在第三级台阶，从第一级到第三级有2种走法（一次上两级台阶，或一次上一级台阶），f(3)=2
实际就是斐波那契数列，第n级台阶的走法为从第n-1上一级台阶，或从n-2上两级台阶，f(n)=f(n-1)+f(n-2)
(PS：递归复杂度指数级，会超时；所以选择用循环实现，复杂度为O(n))
*/

        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        int a=1, b=2, tmp=0;
        for(int i=4; i<=n; i++) {
            tmp = (a+b)%1000000007;
            a = b;
            b = tmp;
        }
        return tmp;
    }
}
