package stack;

import java.util.Stack;

//https://leetcode.com/problems/remove-outermost-parentheses/
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        //
    }
    public String removeOuterParentheses(String S) {
        char [] chars=S.toCharArray();
        StringBuilder sb=new  StringBuilder();
        Stack<Character> st= new Stack<>();
        int startindex=0;
        for ( int i=0;i<chars.length;i++ ) {
            char c= chars[i];
            if(c=='(') {
                st.push('(');
            }else if(c==')') {
                st.pop();
            }
            if(st.isEmpty()) {
                sb.append(S.substring((startindex+1),i));
                startindex=i+1;
            }
        }
        return sb.toString();

    }
}
