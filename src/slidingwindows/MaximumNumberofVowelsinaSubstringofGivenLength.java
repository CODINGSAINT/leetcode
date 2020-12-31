package slidingwindows;
import utils.LeetCode;
import utils.Level;

import java.util.*;
@LeetCode(
        no=1456, title = " Maximum Number of Vowels in a Substring of Given Length", url = "https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/", level = Level.MEDIUM
)
public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public static void main(String[] args) {
        MaximumNumberofVowelsinaSubstringofGivenLength m= new MaximumNumberofVowelsinaSubstringofGivenLength();
        System.out.println(m.maxVowels("aeiou",2));
    }
    public int maxVowels(String s, int k) {
        int i=0;
        int j=0;
        int total=0;
        int max=Integer.MIN_VALUE;
        int len=s.length();
        Set<Character> vowels= Set.of('a', 'e', 'i', 'o', 'u');
        while(i<len){
            char current= s.charAt(i);
            if(vowels.contains(current)){
                total++;
            }
            if(i>=k){
                char vowelAtj= s.charAt(j);
                if(vowels.contains(vowelAtj)){
                    total--;


                }
                j++;

            }
            max= Integer.max(max, total);
            i++;

        }
        return max;

    }
}
