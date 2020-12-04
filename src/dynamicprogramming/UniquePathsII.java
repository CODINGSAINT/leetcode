package dynamicprogramming;

import utils.LeetCode;
import utils.Level;

/**
 *
 */
@LeetCode(no=63,
        title = "Unique Paths II",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/unique-paths-ii/")
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=obstacleGrid.length;
        if(rows==0) return 0;
        if(obstacleGrid[0][0]==1) return 0;
        int cols=obstacleGrid[0].length;

        int [][]dp=new int[rows][cols];
        dp[0][0]=1;
        int obstable=0;
        for(int i=0;i<rows;i++){
            if(obstacleGrid[i][0]==1){
                obstable=1;
            }
            if(obstable==0)
                dp[i][0]=1;
            else
                dp[i][0]=0;
        }

        obstable=0;
        for(int j=0;j<cols;j++){
            if(obstacleGrid[0][j]==1){
                obstable=1;
            }
            if(obstable==0)
                dp[0][j]=1;
            else
                dp[0][j]=0;

        }
        for(int i=1; i<rows;i++){
            for(int j=1;j<cols;j++){

                if(obstacleGrid[i][j]!=1)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[rows-1][cols-1];
    }
}

