import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxUncrossedLines(
                new int[]{10,5,2,1,5,2},new int[]{2,5,1,2,5}));

    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int m=A.length;
        int n=B.length;
        int dp[][]= new int[m+1][n+1];
        int unCrossed=0;
        int uncrossedCol=0;

        for(int row=1;row<m+1;row++)
        {
            for(int col=1;col<n+1;col++)
            {
                if(A[row-1]==B[col-1])
                {
                    dp[row][col]=dp[row-1][col-1]+1;
                }
                else
                {
                    dp[row][col]=Integer.max(dp[row][col-1],dp[row-1][col]);
                }
            }
        }
        return dp[m][n];
    }
}
