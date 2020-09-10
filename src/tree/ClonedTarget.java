package tree;

//1379 Find a Corresponding Node of a Binary Tree in a Clone of That Tree
//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class ClonedTarget {
    public static void main(String[] args) {

    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if(cloned.val == target.val && isSame(cloned, target)){
            return cloned;
        }
        if(original.right != null){
            TreeNode right = getTargetCopy( original.right, cloned.right, target);
            if(right!=null){
                return right;
            }
        }
        if(original.left != null){
            TreeNode left = getTargetCopy( original.left, cloned.left, target);
            if(left!=null){
                return left;
            }
        }
        return null;


    }

    public TreeNode clonedNode(TreeNode original,TreeNode cloned,TreeNode target ) {
        if(cloned.val == target.val && isSame(cloned, target)){
            return original;
        }
        return null;
    }

    public boolean isSame(TreeNode t1, TreeNode t2){

        if(t1==null && t1== null ){
            return true;
        }else if(t1==null  || t2==null ){
            return false;
        }
        return t1.val== t1.val && isSame(t1.right ,t1.right) && isSame(t1.left ,t2.left);
    }
}
