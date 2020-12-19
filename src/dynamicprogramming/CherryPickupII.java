package dynamicprogramming;

public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        int dp[][][] = new int[n+1][m+1][m+1];

        return helper(0,0, m-1, grid,dp,m, n);
    }

    int helper(int i, int j1, int j2, int grid[][], int dp[][][] ,int m, int n){

        //System.out.println("i="+i +" j1 = "+j1+" j2="+j2+ " m ="+m +" n= "+n);

        if(j1<0|| j2<0 ||j1==m||j2==m) return Integer.MIN_VALUE;
        if(i==n) return 0;
        if(dp[i][j1][j2]!=0)
            return dp[i][j1][j2];

        int ans= grid[i][j1] + (j1==j2?0: grid[i][j2]);
        int operations=0;
        for(int x=-1;x<2;x++){
            for(int y=-1;y<2;y++){
                operations=Integer.max(operations, helper(i+1, j1+x, j2+y , grid, dp,m,n));
            }
        }
        return ans+operations;
    }
}