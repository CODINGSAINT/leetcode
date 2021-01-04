package slidingwindows;
import java.util.*;

import utils.LeetCode;
import utils.Level;

@LeetCode(no =76 ,
        level = Level.HARD ,
        title = "Minimum Window Substring",
        url="https://leetcode.com/problems/minimum-window-substring/")
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
    String minimumWindow="";
    int min=Integer.MAX_VALUE;
    Map<Character, Integer>  freq= new HashMap<>();
        for (int i = 0; i <t.length() ; i++) {
        char current=t.charAt(i);
        freq.compute(current,(key, value)-> value==null?1:value+1);
    }

    int st=0;
    int count=0;
    int subStringSt=0;
    int minLength=s.length()+1;
        for (int end = 0; end < s.length() ; end++) {
        char current=s.charAt(end);
        if(freq.containsKey(current)){
            freq.put(current, freq.get(current)-1);
            if(freq.get(current)>=0)
                count++;
        }

        while(count==t.length()){
            //Shrink The Window
            if(end-st+1<minLength){
                minLength=end-st+1;
                subStringSt=st;
            }
            char charAtStart= s.charAt(st++);
            if(freq.containsKey(charAtStart)){
                if(freq.get(charAtStart)==0)
                    count--;
                freq.put(charAtStart, freq.get(charAtStart)+1);

            }
        }
    }
        return minLength > s.length() ? "": s.substring(subStringSt,subStringSt+ minLength) ;


}
}