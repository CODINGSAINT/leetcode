package slidingwindows;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=395 ,
        title=" Longest Substring with At Least K Repeating Characters",
        level= Level.MEDIUM,
        url = "https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/")
public class LongestSubstringwithAtLeastKRepeatingCharacter {
    public int longestSubstring(String s, int k) {
        int n=s.length();
        if(s.length()<k)
            return 0;


        boolean isPossible=false;
        int oc[]= new int[26] ;
        for(char c:s.toCharArray()){
            oc[c-'a'] ++;
            if(oc[c-'a']>=k){
                isPossible =true;
            }
        }
        if(!isPossible){
            return 0;
        }
        int st=0;


        while(st<n && oc[s.charAt(st)-'a']>=k ) {
            //   System.out.println(st);
            st++;
        }
        //System.out.println(st);
        if(st>=n-1)
            return st;

        // System.out.println("left");

        int leftSide= longestSubstring(s.substring(0,st),  k) ;

        while(st<n && oc[s.charAt(st)-'a']<k) st++;

        int rightSide= 0 ;
        //  System.out.println("rigt");


        if(st<n)
            rightSide=  longestSubstring(s.substring(st),  k) ;



        return Integer.max(leftSide,rightSide);

    }

}
