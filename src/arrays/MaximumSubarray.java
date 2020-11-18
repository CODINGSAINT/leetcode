package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=53,
        url = "https://leetcode.com/problems/maximum-subarray/",
        level = Level.EASY,
        title = "Maximum Subarray")
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int maxCurr=nums[0];
        for(int i=1;i<nums.length;i++){
            // System.out.println("current="+nums[i] +" Max "+max);

            maxCurr=Integer.max(nums[i],maxCurr+nums[i]);
            // System.out.println("maxCurr="+maxCurr);

            if(maxCurr>max)
                max=maxCurr;

        }
        return max;
    }
}
