package tree;
//https://leetcode.com/problems/subtree-of-another-tree/
//572. Subtree of Another Tree
public class SubtreeofAnotherTree {
    public static void main(String[] args) {


    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) {
            return false;
        }
        return same(s,t)||isSubtree(s.left,t) ||isSubtree(s.right,t);
    }


    boolean same(TreeNode root, TreeNode mirror){
        if(root==null && mirror==null)
            return true;
        if(root==null && mirror!=null  ||root!=null && mirror==null  )
            return false;
        if (root.val != mirror.val)
            return false;

        return same( root.left,  mirror.left) && same( root.right,  mirror.right);

    }
}

