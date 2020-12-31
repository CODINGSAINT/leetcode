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
        HashMap<Character, Integer> map= new HashMap<>();
        int n= str.length();
        int max=0;
        int j=0;
        for (int i = 0; i <n ; i++) {
            char c=str.charAt(i);
            if(map.containsKey(c)){
                j= Math.max(j, map.get(c)+1);
            }
            map.put(c,i);
            max=Integer.max(max,i+1-j);
        }
        return max;
    }
}
