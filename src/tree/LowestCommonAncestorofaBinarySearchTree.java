package tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofaBinarySearchTree {
    public static void main(String[] args) {
       TreeNode t= new TreeNode(6);
       t.left= new TreeNode(2);
       t.left.left= new TreeNode(0);
        t.left.right= new TreeNode(4);
        t.left.right.left= new TreeNode(3);
        t.left.right.right= new TreeNode(5);

        t.right= new TreeNode(8);
        t.right.left= new TreeNode(7);
        t.right.right= new TreeNode(9);

        LowestCommonAncestorofaBinarySearchTree l = new LowestCommonAncestorofaBinarySearchTree();
        System.out.println(l.lowestCommonAncestor(t,t.left.right.left , t.left.right.right));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p,q);
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left, p,q);

        return root;
    }


}
