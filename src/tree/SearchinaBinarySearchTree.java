package tree;

import java.util.Stack;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchinaBinarySearchTree {
    public static void main(String[] args) {
        //
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        var st = new Stack<TreeNode>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode tmp = st.pop();

            if (tmp.val == val) {
                return tmp;
            }
            if (tmp.right != null) {
                st.push(tmp.right);
            }
            if (tmp.left != null) {
                st.push(tmp.left);
            }
        }
        return null;

    }
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root !=null)

    {
        final var currVal = root.val;
        if (currVal == val)
            return root;
        if (val < currVal)
            root = root.left;
        else
            root = root.right;
    }

        return null;
}
    //recursive
    public TreeNode searchBSTR(TreeNode root, int val) {
        if (root == null)
            return root;
        if (root.val > val)
            return searchBST(root.left, val);
        else if (root.val < val)
            return searchBST(root.right, val);
        else
            return root;
    }

}
