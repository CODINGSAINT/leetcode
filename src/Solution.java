import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumSize(new int[]{2, 4, 8, 2}, 4));
    }


    public int minimumSize(int[] nums, int maxOperations) {
        int high = Integer.MAX_VALUE;
        int ans=0;
        int low = 0;
        while (low <= high) {
            int mid = low+(high - low) / 2;
            if (validate(nums, maxOperations, mid)) {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    private boolean validate(int[] nums, int maxOperations, int mid) {
        for (int i = 0; i < nums.length; i++) {
            maxOperations-=nums[i]/mid;
            if(nums[i]%mid==0) maxOperations++;
        }
        return maxOperations>=0;
    }

}