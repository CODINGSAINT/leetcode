package graph;

import java.util.Stack;

public class JumpGameIII {
    public static void main(String[] args) {
        JumpGameIII j = new JumpGameIII();
        System.out.println(j.canReach(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0}, 3));
    }

    public boolean canReach(int[] arr, int start) {
        if (arr.length == 0) return false;
        boolean[] visited = new boolean[arr.length];
        Stack<Integer> st = new Stack();
        st.add(start);
        while (!st.isEmpty()) {
            int i = st.pop();

            if (arr[i] == 0) {
                return true;
            }
            //visit i
            visited[i] = true;
            //Check if i + arr[i] and i - arr[i] can be visited or not
            if ((i + arr[i]) < arr.length && !visited[i + arr[i]]) {
                st.add(i + arr[i]);
            }
            if ((i - arr[i]) > -1 && !visited[i - arr[i]]) {
                st.add(i - arr[i]);
            }
        }
        return false;
    }
}
