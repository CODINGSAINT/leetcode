package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.List;
@LeetCode(no=442, title = "Find All Duplicates in an Array",level = Level.MEDIUM,  url = "https://leetcode.com/problems/find-all-duplicates-in-an-array/"
)
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> vals= new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1] <0){
                vals.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i])-1]= 0-nums[Math.abs(nums[i])-1];

        }
        return vals;
    }
}
