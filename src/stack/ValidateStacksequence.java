package stack;

import utils.LeetCode;
import utils.Level;

import java.util.*;

@LeetCode(no = 946,
        level = Level.MEDIUM,
        title = "Validate Stack sequence",
        url = "https://leetcode.com/problems/validate-stack-sequences/")
public class ValidateStacksequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;

        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i : popped)
            q.add(i);
        for (int i : pushed) {
            st.push(i);
            int x = st.peek();
            int y = q.peek();
            while (!st.isEmpty() && x == y) {
                st.pop();
                q.poll();
                if (!st.isEmpty()) {
                    x = st.peek();
                    y = q.peek();
                }
            }
        }
        return st.isEmpty();

    }
}
