package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left= new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right= new TreeNode(3);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(7);
        BinaryTreePostorderTraversal b= new  BinaryTreePostorderTraversal();
        List<Integer> res=b.postorderTraversal(root);
        res.stream().forEach(i-> System.out.println(i));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if(root==null)
            return res;

        Stack<TreeNode> st= new Stack<>();
        st.push(root);
        TreeNode prev=null;
        while(!st.isEmpty()){
            TreeNode current=st.peek();
            if(prev==null || prev.left ==current || prev.right== current){
                if(current.left!=null)
                    st.push(current.left);
                else if(current.right!=null)
                    st.push(current.right);
            }else if(current.left==prev) {
                if (current.right != null)
                    st.push(current.right);
            }else{
                    res.add(current.val);
                    st.pop();
                }
            prev=current;
        }
    return res;
    }
}
