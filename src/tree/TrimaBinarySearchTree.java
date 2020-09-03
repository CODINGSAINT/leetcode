package tree;
//669 https://leetcode.com/problems/trim-a-binary-search-tree/
public class TrimaBinarySearchTree {
    public static void main(String[] args) {
        TreeNode t= new TreeNode(3);
        t.left= new TreeNode(0);
        t.left.right=new TreeNode(2);
        t.left.right.left= new TreeNode(1);

        t.right=new TreeNode(3);
        TrimaBinarySearchTree tbst= new TrimaBinarySearchTree();
        TreeNode trimmed= tbst.trimBST(t,1,3);
        System.out.println(trimmed);
    }
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)
            return root;


        if(root.val<L)
            return trimBST(root.right,L,R) ;
        if(root.val>R)
            return trimBST(root.left,L,R) ;

        root.left= trimBST(root.left,L,R);
        root.right= trimBST(root.right,L,R);
        return root;



    }
}
