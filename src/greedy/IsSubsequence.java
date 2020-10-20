package greedy;
//392. Is Subsequence | https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0 ) return true;
        if(t.length()==0 ) return false;

        char chars[]=t.toCharArray();
        char currChar=s.charAt(0);
        int total=0;
        for(int i=0;i<chars.length;i++){
            if (chars[i]==currChar) {
                total++;
                if(total==s.length()) return true;
                currChar=s.charAt(total);
            }
        }
        return false;
    }
}
