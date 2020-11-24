package dynamicprogramming;

import utils.LeetCode;
import utils.Level;

/**
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 *
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 5
 * Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 * Example 2:
 *
 * Input: n = 2
 * Output: 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Sorted Vowel Strings.
 * Memory Usage: 35.7 MB, less than 80.01% of Java online submissions for Count Sorted Vowel Strings.
 */
@LeetCode(no = 1641,
        title = "Count Sorted Vowel Strings",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/count-sorted-vowel-strings/")
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int dp[][] = new int[n + 1][6];
        for (int y = 1; y <= n; y++) {
            for (int x = 5; x >= 1; x--) {
                if (x == 5)
                    dp[y][x] = 1;
                else
                    dp[y][x] = dp[y - 1][x] + dp[y][x + 1];
            }
        }
        int sum = 0;
        int result[] = dp[n];
        for (int x : result) {
            sum += x;
        }

        return sum;

    }
}
