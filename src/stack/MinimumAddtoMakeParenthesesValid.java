package stack;

import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        Stack<Character> st= new Stack();
        for(int i=0;i< s.length();i++){
            char current=s.charAt(i);
            if(current== '('){
                st.push(current);

            }else if(current== ')'){
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }else{
                    st.push(current);
                }
            }
        }
        return st.size();

    }
}
