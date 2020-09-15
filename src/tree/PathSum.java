package tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

       return preorder(root ,sum);
}
    boolean preorder(TreeNode node,int sum){

        if(node != null) {
            if( node.val== sum && (node.right==null && node.left==null) )
                return (true);


            return preorder(node.left ,sum-node.val) ||  preorder(node.right ,sum-node.val) ;
        }
        return false;


    }
}
