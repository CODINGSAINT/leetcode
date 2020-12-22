package tree;

public class BalancedBinaryTree {
    boolean isBalanced=true;
    public boolean isBalanced(TreeNode root) {
        if(root ==null) return true;
        findBalanced(root);
        return isBalanced;
    }

    int findBalanced(TreeNode node ){
        if (node==null) return 0;

        int left= findBalanced(node.left);
        int right= findBalanced(node.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
            return Integer.MIN_VALUE;
        }
        return Math.max(left,right) +1;


    }
}