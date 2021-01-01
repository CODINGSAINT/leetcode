package slidingwindows;

import utils.LeetCode;
import utils.Level;
import java.util.*;

@LeetCode(no=424,
        title= "Longest Repeating Character Replacement",
        url = "https://leetcode.com/problems/longest-repeating-character-replacement/",
        level = Level.MEDIUM)
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int st=0;
        int end=0;
        int max=0;
        int maxLen=0;
        int len=s.length();
        Map<Character,Integer> freq= new HashMap<>();
        for(end=0;end<len;end++){
            char current= s.charAt(end);
            freq.compute(current, (key, value)-> value==null ?1 :value +1);
            int currentFreq= freq.get(current);
            max= Math.max(max, currentFreq);
            while(end-st-max+1>k){
                char start= s.charAt(st );
                int startCount = freq.get(start);
                freq.put(start,--startCount);
                st++;

            }
            maxLen= Math.max(maxLen, end-st+1);

        }
        return maxLen;

    }
}
