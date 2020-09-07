package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
//345. Reverse Vowels of a String
public class ReverseVowelsofaString {
    public static void main(String[] args) {

    }
    public String reverseVowels(String s) {
        Stack<Character> st= new Stack();
        Set<Character> l= Set.of('a','e','i','o','u','A','E','I','O','U');
        for(int i=0;i<s.length();i++){
            if(l.contains( s.charAt(i))) {
                st.push( s.charAt(i));
            }
        }
        char [] c= new char[s.length()];
        for(int i=0;i<s.length();i++){
            if(l.contains( s.charAt(i) )) {
                c[i]=st.pop();
            }else{
                c[i]=s.charAt(i);
            }
        }
        return new String (c);

    }
}
