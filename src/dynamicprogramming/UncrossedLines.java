package dynamicprogramming;
//1035. Uncrossed Lines M
//https://leetcode.com/problems/uncrossed-lines/
public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int dp[][] = new int[m + 1][n + 1];

        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                if (A[row - 1] == B[col - 1]) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Integer.max(dp[row][col - 1], dp[row - 1][col]);
                }
            }
        }
        return dp[m][n];

    }
}