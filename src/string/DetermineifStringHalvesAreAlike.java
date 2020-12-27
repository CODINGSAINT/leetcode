package string;

import java.util.Set;

public class DetermineifStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int len= s.length();

        String s1= s.substring(0, len/2);
        String s2= s.substring(len/2);
        // System.out.println(s1+" "+s2);
        Set<Character> set= Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count1=0;
        int count2 =0;
        for(int i=0;i<s1.length();i++){
            if(set.contains(s1.charAt(i))) count1++;
        }
        for(int i=0;i<s2.length();i++){

            if(set.contains(s2.charAt(i))) count2++;

        }
        return count1==count2;
    }
}
