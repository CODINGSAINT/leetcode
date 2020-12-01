package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=283 ,title="Move Zeroes" , level = Level.EASY, url = "https://leetcode.com/problems/move-zeroes/")
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length==0) return ;
        int nonZero=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0){
                swap(nums,i,nonZero);
                nonZero++;
            }
        }

    }

    void swap(int nums[], int i , int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}

