package arrays;
//41. First Missing Positive
//https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;
        int missing[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<missing.length&&nums[i]>0){
                missing[nums[i]]=nums[i];
            }
        }
        for(int i=1;i<missing.length;i++){
            if(i!=missing[i])
                return i;
        }
        return missing.length;
    }
}
