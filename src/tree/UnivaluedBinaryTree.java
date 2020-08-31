package tree;

import java.util.Stack;

public class UnivaluedBinaryTree {
    public static void main(String[] args) {

    }
    public boolean isUnivalTree(TreeNode root) {
        boolean isUnivalTree=true;

        int currentValue=root.val;
        TreeNode current= root;
        Stack<TreeNode> st= new Stack();
        st.push(current);
        while(!st.isEmpty()){

            current=st.pop();
            if(current.val!=currentValue){
                isUnivalTree=false;
                break;
            }
            if(current.right!=null){
                st.push(current.right);
            }
            if(current.left!=null){
                st.push(current.left);
            }
        }
        return isUnivalTree;
    }
}
