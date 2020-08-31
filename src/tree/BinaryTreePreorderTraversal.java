package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left= new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right= new TreeNode(3);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(7);
        BinaryTreePreorderTraversal b= new  BinaryTreePreorderTraversal();
        List<Integer> res=b.preorderTraversal(root);
        res.stream().forEach(i-> System.out.println(i));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sol= new ArrayList();
        if (root==null){
            return sol;
        }
        Stack<TreeNode> st= new Stack();
        TreeNode current=root;
        st.push(root);

        while(!st.isEmpty()){
            current=st.pop();
            sol.add(current.val);
            if(current.right!=null)
                st.add(current.right);
            if(current.left!=null)
                st.add(current.left);

        }
        return sol;

    }
}
