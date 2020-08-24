package stack;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {

    }

    public String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!st.isEmpty()) {
                char top = st.peek();
                if (top == c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else {
                st.push(c);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (char s : st) {
            sb.append(Character.toString(s));
        }
        return sb.toString();
    }
}
