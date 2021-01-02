package slidingwindows;

import java.util.*;

public class PermutationinString {
    public static void main(String[] args) {
        PermutationinString p = new PermutationinString();
        // System.out.println( p.checkInclusion("bcdyabcdx", "bcdxabcdy"));
        System.out.println(p.checkInclusion("ab", "eidbaooo"));
        //System.out.println( p.checkInclusion("ab", "eidboaoo"));
        //System.out.println( p.checkInclusion("abc", "aaacb"));


    }

    public boolean checkInclusion(String s1, String s2) {
        return findPermutation(s2, s1);
    }


    public boolean findPermutation(String str, String pattern) {
        HashMap<Character, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);


        }
        int matched = 0;
        int start = 0;
        int end = 0;
        for (char current : str.toCharArray()) {


            if (patternMap.containsKey(current)) {
                patternMap.put(current, patternMap.get(current) - 1);
                if (patternMap.get(current) == 0) matched++;
                //matched++;
            }


            if (matched == patternMap.size()) return true;
            if (end + 1 >= pattern.length()) {
                char startChar = str.charAt(start);
                if (patternMap.containsKey(startChar)) {
                    if (patternMap.get(startChar) == 0) {
                        matched--;
                    }
                    patternMap.put(startChar, patternMap.get(startChar) + 1);

                }
                start++;
            }
            end++;

        }


        return false;
    }


}