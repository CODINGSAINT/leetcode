package tree;
//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public static void main(String[] args) {
//
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode t= root.left;
        root.left=root.right;
        root.right=t;

        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;

    }
}
