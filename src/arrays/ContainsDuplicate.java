package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;

@LeetCode(no=217, level = Level.EASY, url = "https://leetcode.com/problems/contains-duplicate/",title = "Contains Duplicate")
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums) ;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;

    }
}