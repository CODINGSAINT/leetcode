package tree;

import java.util.Stack;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
    }

//recursive
    public TreeNode mergeTreesR(TreeNode t1, TreeNode t2) {
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;
        t1.val=t1.val+t2.val;
        t1.left=mergeTreesR(t1.left,t2.left);
        t1.right=mergeTreesR(t1.right,t2.right);
        return t1;
 }
    //interative
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack<TreeNode[]> st= new Stack<>();
        st.push(new TreeNode[] {t1,t2});
        while (!st.isEmpty()){
            TreeNode[] t= st.pop();
            if(t[0]==null || t[1]==null){
                continue;
            }

            t[0].val+= t[1].val;
            if(t[0].left==null){
                t[0].left=t[1].left;
            }else {
                st.push(new TreeNode[]{t[0].left ,t[1].left});
            }
            if(t[0].right==null){
                t[0].right=t[1].right;
            }else {
                st.push(new TreeNode[]{t[0].right ,t[1].right});
            }
        }

        return t1;


    }
}
