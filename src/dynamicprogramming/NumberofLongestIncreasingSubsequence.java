package dynamicprogramming;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;

@LeetCode(no=673,
        title = "Number of Longest Increasing Subsequence",
        level = Level.MEDIUM,
        url="https://leetcode.com/problems/number-of-longest-increasing-subsequence/")
public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int dp[]= new int[nums.length];
        Arrays.fill(dp,1 );
        int count[]=new int [nums.length];
        Arrays.fill(count,1 );
        int maxLength=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }else if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                }
            }
            maxLength=Math.max(maxLength,dp[i]);


        }
        int result=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]==maxLength)
                result+=count[i];
        }




        return result;
    }
}
