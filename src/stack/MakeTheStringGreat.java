package stack;

import java.util.Stack;
//https://leetcode.com/problems/make-the-string-great/
public class MakeTheStringGreat {
    public static void main(String[] args) {

    }

    public String makeGood(String s) {
        Stack<Character> st= new Stack<>();
        char[] chars= s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char currLetter=chars[i];
            if(!st.isEmpty()){
                char top=st.peek();
                int topLetter=top;
                if( (currLetter+32)==top || (currLetter-32)==top){
                    st.pop();
                }else{
                    st.push(currLetter);
                }
            }else{
                st.push(currLetter);
            }

        }
        StringBuilder sb= new StringBuilder();
        for(char s1:st){
            sb.append(Character.toString(s1));
        }
        return sb.toString();


    }
}
