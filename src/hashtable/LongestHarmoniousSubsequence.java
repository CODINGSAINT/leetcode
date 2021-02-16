package hashtable;

import java.util.HashMap;
//Longest Harmonious Subsequence
//https://leetcode.com/problems/longest-harmonious-subsequence/
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int result = 0;

        for(int num : nums){
        int prev = map.getOrDefault(num - 1, 0);
        int next = map.getOrDefault(num  + 1, 0);

        int max = Math.max(prev, next);

        int curr = map.getOrDefault(num, 0);
        map.put(num, curr + 1);

        if(max == 0){
            continue;
        }

        result = Math.max(result,  max + curr + 1);
    }

        return result;


}
}
