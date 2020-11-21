package binarysearch;

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int st = 0;
        int end = nums.length - 1;

        while (end >= st) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target || nums[st] == target || nums[end] == target) {
                if (nums[mid] == target)
                    return mid;
                if (nums[st] == target)
                    return st;
                if (nums[end] == target)
                    return end;
            }
            // which side is sorted
            if (nums[st] < nums[mid]) {
                //  System.out.println("target"+target+" nums[mid] "+nums[mid]+"  nums[st] "+ nums[st] );
                if (target < nums[mid] && nums[st] < target) {//target is between these two
                    end = mid - 1;
                } else {//target lies in other side
                    st = mid + 1;
                }


            } else if (nums[mid] < nums[end]) {// this side is sorted

                // System.out.println("Dote2");
                if (target > nums[mid] && target < nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                return -1;
            }

        }
        return -1;
    }
}
