package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//1249  Minimum Remove to Make Valid Parentheses
public class MinimumRemovetoMakeValidParentheses {
    public static void main(String[] args) {
        //

    }
    public String minRemoveToMakeValid(String s) {
        char[] chars=s.toCharArray();
        Stack<Character> st1= new Stack();
        List<Integer> pos=new ArrayList<>();
        StringBuffer sb= new StringBuffer();
        char currentChar;
        for(int i=0;i<chars.length;i++){
            if( !st1.isEmpty() && chars[i]==')' && st1.peek() =='('){
                st1.pop();
                pos.remove(pos.size()-1);
            }else if(chars[i]==')' || chars[i]=='(') {

                st1.push(chars[i]);
                pos.add(i);
            }
        }
        for(int i=0;i<chars.length;i++){
            if(!pos.contains(i))
                sb.append(chars[i]);
        }
        return sb.toString();

    }
}
