package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//859 https://leetcode.com/problems/buddy-strings/
public class BuddyString {
    public boolean buddyStrings(String A, String B) {

        if(A.length()!=B.length()) return false;

        if(A.equals(B)){
            Set<Character> chars= new HashSet<>();
            for(int i=0;i<A.length();i++){
                chars.add(A.charAt(i));
            }
            return chars.size()<A.length();
        }


        List<Integer> diffCount=new ArrayList<>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i) )
                diffCount.add(i);
        }
        if(diffCount.size()>2)
            return false;

        return diffCount.size()==2
                && A.charAt(diffCount.get(0))== B.charAt(diffCount.get(1))
                && B.charAt(diffCount.get(0))== A.charAt(diffCount.get(1));
    }
}
