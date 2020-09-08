package tree;

import com.sun.source.tree.Tree;

//101. Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode t= new TreeNode(1);
        t.left= new TreeNode(2);
        t.right= new TreeNode(2);

        t.left.right= new TreeNode(3);
        t.right.right= new TreeNode(3);
        SymmetricTree s= new SymmetricTree();
        System.out.println(s.isSymmetric(t));

    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return false;
        TreeNode mirrorNode= new TreeNode();
         mirrorNode=clone(root,mirrorNode);
        mirrorNode=    mirror(mirrorNode);

        return same(root,  mirrorNode);

    }
    private TreeNode clone (TreeNode t, TreeNode cloned){
        if(t!=null){
            cloned= new TreeNode(t.val);
        }
        if(cloned!=null) {
            cloned.left = clone(t.left, cloned.left);
            cloned.right = clone(t.right, cloned.right);
        }
        return cloned;
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

    TreeNode mirror(TreeNode node){
        if (node == null)
            return null;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        node.right = mirror(node.right);
        node.left = mirror(node.left);

        return node;

    }
}
