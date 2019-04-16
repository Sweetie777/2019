package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/14
 */
public class nowcoder2 {


    //求最长公共子串
    //动态规划问题
    public static int findLongest(String A, int n, String B, int m) {
        // write code here
        if(n==0 || m==0)
            return 0;
        int max=0;
        int[][] dp=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A.charAt(i)==B.charAt(j)){
                    if(i==0 || j==0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=dp[i-1][j-1]+1;
                }
                max=Math.max(dp[i][j], max);
            }
        }
        return max;
    }


}
