package binarysearch;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
       // int min= Integer.MAX_VALUE;

        int low=0;
        int high= nums.length-1;
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        while(high>low+1){
            int mid=low +(high-low)/2;


            if(nums[mid]>nums[low]){
                //  min= Integer.min(nums[low], min);
                low=mid;
            }else {
                // min= Integer.min(nums[mid], min) ;
                high=mid;

            }
        }
        int  min= Integer.min(nums[high], nums[low]);
        return min;
    }
}
