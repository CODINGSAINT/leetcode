package arrays;

import java.util.ArrayList;
import java.util.List;

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
