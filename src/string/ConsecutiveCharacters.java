package string;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;

@LeetCode(no = 1446,
        title = "Consecutive Characters",
        level = Level.EASY,
        url = "https://leetcode.com/problems/consecutive-characters/")
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s.length() == 1) return 1;
        char arr[] = s.toCharArray();
        int dp[] = new int[arr.length];
        int current[] = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.fill(current, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                current[i] = current[i] + current[i - 1];

            }
            dp[i] = Math.max(dp[i - 1], current[i]);
        }
        return dp[arr.length - 1];
    }

    public int maxPowerWithoutDp(String s) {
        int maxOrder = 1;
        int currOrder = 1;
        for(int i = 1; i < s.length(); ++i){
            currOrder =(s.charAt(i - 1) == s.charAt(i))? currOrder + 1: 1;
            maxOrder = Math.max(maxOrder, currOrder);
        }
        return maxOrder;
    }

}
