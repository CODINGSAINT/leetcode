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
        {
            HashMap<Character, Integer> freq= new HashMap<>();
            for(int i=0;i<s1.length();i++){
                char current= s1.charAt(i);
                freq.put(current , freq.getOrDefault(current,0)+1 );
            }

            int st=0;
            int end=0;
            int matched=0;
            for(char current:s2.toCharArray()){
                //char current= s2.charAt(end);
                if(freq.containsKey(current)){
                    freq.put(current, freq.get(current)-1);
                    if(freq.get(current)==0) matched++;
                }
                if(matched==freq.size()) return true;

                if(end+1>=s1.length()){
                    char char_at_start= s2.charAt(st);
                    if(freq.containsKey(char_at_start)){
                        if(freq.get(char_at_start)==0) matched--;
                        freq.put(char_at_start, freq.get(char_at_start)+1);

                    }
                    st++;
                }
                end++;
            }
            return false;
        }
    }


}