package stack;

import java.util.Stack;
// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public static void main(String[] args) {
    //
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (!st.isEmpty()) {
                    char top = st.peek();
                    if (top == '(' && c == ')') {
                        st.pop();
                    } else if (top == '{' && c == '}') {
                        st.pop();
                    } else if (top == '[' && c == ']') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }


    }
}
