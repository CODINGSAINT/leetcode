package arrays;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {

    }
    public int calPoints(String[] ops) {
        if (ops.length == 0) return 0;
        int total = 0;
        Stack<Integer> st = new Stack();
        for (int i = 0; i < ops.length; i++) {
            String current = ops[i];
            if (current.equals("C")) {
                if (!st.isEmpty()) {

                    total -= st.pop();
                }

            } else if (current.equals("D")) {
                int currRound = 2 * st.peek();
                total += currRound;
                st.push(currRound);
            } else if (current.equals("+")) {
                int k = st.pop();
                int s = k + st.peek();
                st.add(k);
                total += s;
                st.add(s);

            } else {
                int currScore = Integer.parseInt(current);
                st.push(currScore);
                total += currScore;
            }
        }
        return total;

    }
}
