package binarysearch;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int st=0;
        int end=nums.length-1;

        while(end>=st){
            int mid=st+(end-st)/2;

            if(nums[mid]==target || nums[st]==target|| nums[end]==target){
                return true;
            }
            // which side is sorted
            if(nums[st]<nums[mid]){
                if(target<nums[mid] && nums[st]<target){//target is between these two
                    end=mid-1;
                }else{//target lies in other side
                    st=mid+1;
                }


            }else if( nums[mid]<nums[end]){// this side is sorted
                if(target> nums[mid] && target< nums[end]){
                    st=mid+1;
                }else{
                    end=mid-1;
                }
            }else{
                end--;

            }

        }
        return false;
    }
}