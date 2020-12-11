package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;

/**
 *
 */
@LeetCode(no=169, level = Level.EASY, url = "https://leetcode.com/problems/majority-element/",title = "Majority Element")
public class MajorityElement
{
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int majority=n/2;
        Arrays.sort(nums);
        int count=1;
        int majorityElem=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                count++;
                if(count>majority){
                    majorityElem=nums[i];
                    break;
                }

            }else
                count=1;
        }return majorityElem;
    }
}
