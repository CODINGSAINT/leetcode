package arrays;
import utils.LeetCode;
import utils.Level;

import java.util.*;
@LeetCode(no=15, level = Level.MEDIUM, url = "https://leetcode.com/problems/3sum/",title = "3Sum")
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> results= new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int next= i+1;
            int last=nums.length-1;
            while(next<last) {
                int currentSum= nums[i]+nums[next]+nums[last];

                if(currentSum==0){
                    results.add(List.of(nums[i],nums[next],nums[last]));
                    last--;
                    next++;
                }else if(currentSum>0){
                    last--;
                }else if(currentSum<0){
                    next++;
                }
            }

        }
        List<List<Integer>> finalRes= new ArrayList<>(results);

        return finalRes ;
    }
}
