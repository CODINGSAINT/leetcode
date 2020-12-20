package slidingwindows;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public static void main(String[] args) {
        MaximumErasureValue m = new MaximumErasureValue();
        m.maximumUniqueSubarray(new int[]{10000, 1, 10000, 1, 1, 1, 1, 1, 1});
    }

    public int maximumUniqueSubarray(int[] nums) {
        int[] map = new int[10001];
        int l = 0, r = 0, sum = 0, max = 0;
        while (r < nums.length) {
            map[nums[r]]++;
            sum += nums[r];
            while (map[nums[r]] >= 2) {
                map[nums[l]]--;
                sum -= nums[l];
                l++;
            }
            r++;
            max = Math.max(max, sum);
        }
        return max;


    }
}
