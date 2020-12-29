package stack;

import utils.LeetCode;
import utils.Level;

import java.util.Stack;

@LeetCode(no=1541,
        url = "https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/",
        title = " Minimum Insertions to Balance a Parentheses String",
        level = Level.MEDIUM)
public class MinimumInsertionstoBalanceaParenthesesString {

    public int minInsertions(String s) {
        char[] sChars= s.toCharArray();
        int n= sChars.length;
        int total=0;
        Stack<Character> st= new Stack<>();
        for(int i=0;i<sChars.length;i++){
            char c= sChars[i];
            if(c=='('){
                st.push('(');
                continue;
            }
            if(st.isEmpty()){
                if(i<n-1){
                    char next= sChars[i+1];
                    if(c==next){
                        total++;
                        i+=1;
                    }else {
                        total+=2;
                    }
                }else{
                    total+=2;

                }
            }else {
                if(i<n-1){
                    char next= sChars[i+1];
                    if(c==next){
                        st.pop();
                        // total++;
                        i+=1;
                    }else {
                        st.pop();
                        total+=1;
                    }
                }else{
                    st.pop();
                    total+=1;

                }
            }
        }
        if(!st.isEmpty())
            total+=2*st.size();

        return total;
    }
}

