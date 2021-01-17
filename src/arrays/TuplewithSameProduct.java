package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//1726. Tuple with Same Product
public class TuplewithSameProduct
{
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int v = cnt.getOrDefault(nums[i] * nums[j], 0);
                cnt.put(nums[i] * nums[j], v+1);
            }
        }
        int ans = 0;
        for(Integer v : cnt.values()) {
            ans += 4 * v * (v-1);
        }
        return ans;
    }
}
