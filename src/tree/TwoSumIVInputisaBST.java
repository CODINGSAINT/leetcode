package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/


public class TwoSumIVInputisaBST {
    public static void main(String[] args) {
        TreeNode t= new TreeNode(2);
        t.right= new TreeNode(3);
        TwoSumIVInputisaBST ts= new TwoSumIVInputisaBST();
        ts.findTarget(t,6);
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }

        Stack<TreeNode> st= new Stack();
        st.push(root);
        Map<Integer,Integer> m = new HashMap();
        while(!st.isEmpty()) {
            TreeNode tmp=st.pop();
            int count= m.getOrDefault(tmp.val ,0);
            m.put(tmp.val, count+1);

            if(tmp.right!=null ){
                st.push(tmp.right);
            }
            if(tmp.left!=null){
                st.push(tmp.left);
            }
            int compliment = k-tmp.val;
            int countOfComplement=m.getOrDefault(compliment,0);

            if(compliment == tmp.val){
                if(countOfComplement>1){
                    return true;
                }

            }else{
                if(countOfComplement>0){
                    return true;
                }
            }

        }
     return false;
    }
}
