package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.HashMap;
import java.util.Map;

@LeetCode(no = 1711,
        level = Level.MEDIUM,
        title = "Count Good Meals",
        url = "https://leetcode.com/problems/count-good-meals/")
//|1711|[Count Good Meals]()|Medium| [CountGoodMeals]()|
public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {

        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < deliciousness.length; i++) {
            int sum = 1;
            int current = deliciousness[i];
            for (int j = 0; j <= 21; j++) {
                if (sum >= current && freq.containsKey(sum - current)) {
                    count += freq.get(sum - current);

                    count %= 1000000007;
                }
                sum *= 2;
            }
            freq.put(current, freq.getOrDefault(current, 0) + 1);

        }return count;

    }


}
