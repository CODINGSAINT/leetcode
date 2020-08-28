package tree;

import java.util.Stack;

// 938 https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumofBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum=0;
        var st= new Stack<TreeNode>();
        TreeNode current= root;
        st.push(current);
        while(!st.isEmpty()){
            TreeNode tmp= st.pop();
            if(tmp!=null){
                if(L<=tmp.val && tmp.val<=R) {
                    sum+=tmp.val;
                }
                if(tmp.val>L ) {
                    st.push(tmp.left);
                }
                if(tmp.val<R) {
                    st.push(tmp.right);
                }
            }
        }
        return sum;
    }
}
