package dynamicprogramming;
//198. House Robber (https://leetcode.com/problems/house-robber/)
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        return Math.max(dp(nums, 0, nums.length-1),dp( nums, 1, nums.length));

    }

    int dp(int nums[] , int startIndex, int endIndex){
        int dp[]=new int[endIndex];
        dp[startIndex]= nums[startIndex];
        dp[startIndex+1]=Math.max(nums[startIndex], nums[startIndex+1]);
        for(int i=startIndex+2; i<endIndex; i++){
            dp[i] = Math.max(dp[i-1], (dp[i-2]+nums[i] ) );
        }

        return dp[endIndex-1] ;
    }
}
