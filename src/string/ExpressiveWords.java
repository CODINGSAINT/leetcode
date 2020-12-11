package string;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=809, title = "Expressive Words", url = "https://leetcode.com/problems/expressive-words/", level = Level.MEDIUM)
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int counter=0;
        for(String w: words){
            if(isValid(S,w)){
                counter++;
            }
        }
        return counter;
    }
    public boolean isValid(String s, String w){

        int i=0;
        int j=0;

        while(i<s.length() && j<w.length()){
            char sChar=s.charAt(i);
            char wChar= w.charAt(j);
            if(sChar!=wChar)
                return false;

            int iReps= i+1;
            int jReps=j+1;
            while(iReps<s.length() && s.charAt(i)==s.charAt(iReps)){
                iReps++;
            }


            while(jReps<w.length() && w.charAt(j)==w.charAt(jReps)){
                jReps++;
            }

            if(iReps-i !=jReps-j && iReps-i<3) return false;

            if(jReps-j>iReps-i) return false;

            i=iReps;
            j=jReps;
        }
        return i==s.length()&& j==w.length() && s.length() > w.length() ;

    }
}