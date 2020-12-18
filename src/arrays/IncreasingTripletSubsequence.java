package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=334, url="https://leetcode.com/problems/increasing-triplet-subsequence/", level = Level.MEDIUM, title = "Increasing Triplet Subsequence")
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int first=nums[0];
        int second= Integer.MAX_VALUE;

        for(int n:nums){
            if(n<=first)
                first=n;
            else if (n<=second)
                second=n;
            else
                return true;
        }

        return false;
    }
}
