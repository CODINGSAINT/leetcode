package dynamicprogramming;

import java.util.Arrays;

public class StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int n=stones.length;
        int targetSum= Arrays.stream(stones).sum();

        int dp[][] = new int[n+1][n+1];

        return max(dp, 0, stones.length-1, stones,targetSum);


    }

    int max(int dp[][] ,int st, int end,int[] stones, int sum){
        if(st==end)
            return 0;
        if(dp[st][end]!=0)
            return dp[st][end];


        int max = Integer.max(sum-stones[st] -max(dp,st+1, end, stones,sum-stones[st]  ) , sum-stones[end]-max(dp,st,end-1, stones , sum-stones[end]));

        dp[st][end]=max;

        return dp[st][end];

    }
}
