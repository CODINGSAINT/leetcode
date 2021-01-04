package slidingwindows;

import utils.LeetCode;
import utils.Level;

import java.util.HashMap;


@LeetCode(
        no=3, title = "Longest Substring Without Repeating Characters",
        url = "https://leetcode.com/problems/longest-substring-without-repeating-characters/",
        level = Level.MEDIUM
)
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String str) {
        int max= 0;
        HashMap<Character,Integer>freq= new HashMap<>();
        int st=0;
        for (int end = 0; end < str.length(); end++) {
            char current= str.charAt(end);
            if(freq.containsKey(current)) {
                st= Integer.max(st, freq.get(current)+1);
            }
            freq.put(current, end);

            max=Math.max(max, end-st+1);
        }
        return max;


    }
}
