package dynamicprogramming;

import utils.LeetCode;
import utils.Level;

/**
 *
 */
@LeetCode(no=62,
        title = "Unique Paths",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/unique-paths/")
public class UniquePaths {
    public int uniquePaths(int rows, int cols) {
        //nt rows=obstacleGrid.length;
        if (rows == 0) return 0;
        //  if(obstacleGrid[0][0]==1) return 0;
        //int cols=obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1;
        }

        //c=0;
        for (int j = 0; j < cols; j++) {
            dp[0][j] = 1;
        }


        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

            }
        }
        return dp[rows - 1][cols - 1];
    }
}
