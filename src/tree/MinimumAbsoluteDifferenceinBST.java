package tree;

public class MinimumAbsoluteDifferenceinBST {
    Integer previous =null;
    int minimum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode t= new TreeNode(543);
        t.left= new TreeNode(384);
        t.left.right= new TreeNode(445);
        t.right= new TreeNode(652);
        t.right.right= new TreeNode(699);
        MinimumAbsoluteDifferenceinBST m= new MinimumAbsoluteDifferenceinBST();
        System.out.println(m.getMinimumDifference(t));

    }
    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return 0;
        inorder(root);
        return minimum;

    }

    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            if(previous !=null)
                minimum =Math.min(minimum, (root.val - previous));
            previous =root.val;
            inorder(root.right);
        }
    }

}
