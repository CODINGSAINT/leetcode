package binarysearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        if( nums.length==0) return -1;
        return search(nums,target,  nums.length-1, 0);

    }
    int search (int nums[] , int target,int high , int low){
        while(high>=low){
            int mid= (low+high)/2;
            if(target>nums[mid]){
                low=mid+1;
                return search(nums,target, high, low);
            }else if(target<nums[mid]){
                high=mid-1;
                return search(nums,target, high, low);
            }else {

                return mid;
            }
        }
        return -1;
    }
}