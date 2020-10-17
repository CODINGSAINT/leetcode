package dynamicprogramming;
//70. Climbing Stairs
//https://leetcode.com/problems/climbing-stairs/

public class ClimbingStairs {
    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int steps=2;steps<=n;steps++){
            dp[steps]=dp[steps-1] +dp[steps-2];
        }
        return dp[n];
    }
}
