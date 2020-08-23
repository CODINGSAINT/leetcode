package string;

import java.util.Stack;
/*844 https://leetcode.com/problems/backspace-string-compare/ */
public class BackspaceStringCompare {
    public static void main(String[] args) {

    }
    public boolean backspaceCompare(String s, String t) {
        char schar[]=s.toCharArray();
        char tchar[]=t.toCharArray();
        String sFinal=finalStr(schar);
        String tFinal=finalStr(tchar);
        return sFinal.equals(tFinal);
    }

    public String finalStr(char []s){
        Stack<Character> st= new Stack<>();
        for(char c:s){
            if( !st.isEmpty() && c=='#'){
                st.pop();
            }else if(c!='#'){
                st.push(c);
            }
        }
        char[] finalStr=new char[st.size()];
        int i=0;
        while(!st.isEmpty()){
            finalStr[i]=st.pop();
            i++;
        }
        return new String(finalStr) ;
    }
}
