package slidingwindows;
import java.util.*;

import utils.LeetCode;
import utils.Level;

@LeetCode(no =438 ,
        level = Level.MEDIUM ,
        title = "Find All Anagrams in a String",
        url="https://leetcode.com/problems/find-all-anagrams-in-a-string/")
public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results= new ArrayList<>();
        Map<Character, Integer> freq= new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char current= p.charAt(i);
            freq.compute(current, (key, value)-> value==null?1:value+1);


        }
        int start=0;
        int count=0;

        for (int end = 0; end < s.length(); end++) {
            char current= s.charAt(end);
            if (freq.containsKey(current)){

                freq.put(current, freq.get(current)-1);
                if(freq.get(current)==0) count++;
            }
            if(freq.size()==count) {
                results.add(start);
            }
            if(end>=p.length()-1){
                char charAtSt= s.charAt(start);
                if(freq.containsKey(charAtSt)){
                    if(freq.get(charAtSt)==0) count--;


                    freq.put(charAtSt, freq.get(charAtSt)+1);
                }
                start++;
            }

        }

        return results;

    }
}
