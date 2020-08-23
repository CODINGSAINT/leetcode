package stack;

import java.util.Stack;

// 125 https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public static void main(String[] args) {

    }


    public boolean isPalindrome(String s) {
        String rep= s.replaceAll("[^a-zA-Z0-9\\s]", "").replaceAll(" ","").toLowerCase();
        int half= rep.length()/2;
        Stack<Character> st= new Stack<>();
        char[] chars=rep.toCharArray();
        int i=0;
        for( i=0;i<half;i++){
            st.push(chars[i]);
        }
        if(rep.length()%2!=0){
            i++;
        }
        /*  for(int j=chars.length-1;j>half;j--){*/
        while(i<chars.length){
            char current=chars[i];
            if(current!=st.pop()){
                return false;
            }
            i++;
        }
        return st.isEmpty();

    }
}
