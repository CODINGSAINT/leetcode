package dynamicprogramming;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;
@LeetCode(no=300,
        level = Level.MEDIUM,
        title = "Longest Increasing Subsequence",
        url = "https://leetcode.com/problems/longest-increasing-subsequence/")
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        if (nums.length==0) return 0;
        int dp[]= new int[nums.length];
        int max=Integer.MIN_VALUE;

        Arrays.fill(dp,1);

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] &&  dp[i]<= dp[j]){
                    dp[i]=1+dp[j];

                }
            }
        }
        for (int i=0; i<dp.length; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }
}
