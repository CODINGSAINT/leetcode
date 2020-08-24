package stack;

import java.util.Stack;
//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
public class ReverseSubstringsBetweenEachPairofParentheses {
    public static void main(String[] args) {

    }
    public String reverseParentheses(String s) {
        String res="";
        char[] allChar= s.toCharArray();
        Stack<Character> st= new Stack<>();
        for(int i=0;i<allChar.length;i++){
            if(allChar[i]==')'){
                while(st.peek()!='(') {
                    res+=st.pop();
                }
                st.pop();
                for(int j=0;j<res.length();j++){
                    st.push(res.charAt(j));
                }
                res="";
            }else {
                st.push(allChar[i]);
            }
        }
        while (!st.isEmpty()){
            res=st.pop()+res;
        }
        return  res;
    }
}
