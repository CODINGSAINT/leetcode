package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        //
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = leaves(root1);
        List<Integer> seq2 = leaves(root2);
        if (seq1.size() != seq2.size()) {
            return false;
        } else {
            for (int i = 0; i < seq1.size(); i++) {
                if (seq1.get(i) != seq2.get(i)) {
                    return false;
                }
            }

        }

        return true;
    }

    List<Integer> leaves(TreeNode root) {

        List<Integer> leaves = new ArrayList();
        TreeNode current = root;
        if (current == null) {
            return leaves;
        }
        Stack<TreeNode> st = new Stack<>();
        boolean isDone = false;
        while (!isDone) {
            if (current != null) {
                st.push(current);
                current = current.left;
            } else {
                if (st.isEmpty()) {
                    isDone = true;
                } else {
                    current = st.pop();
                    if (current.right == null && current.left == null) {
                        leaves.add(current.val);
                    }
                    current = current.right;
                }
            }


        }
        return leaves;
    }
}
