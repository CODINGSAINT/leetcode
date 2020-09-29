package tree;
//1008. Construct Binary Search Tree from Preorder Traversal
public class ConstructBinarySearchTreefromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] p) {
        TreeNode root= new TreeNode(p[0]) ;
        TreeNode ref= root;
        TreeNode lastNode=root;
        for(int i=1;i<p.length;i++) {
            while(root!=null) {
                if(root.val>p[i] ){
                    lastNode= root;
                    root=root.left;
                }
                else if(root.val<p[i]) {
                    lastNode= root;
                    root=root.right;
                }

            }
            if(lastNode.val>p[i]) {
                lastNode.left= new TreeNode(p[i]);
            }else if (lastNode.val<p[i]) {
                lastNode.right= new TreeNode(p[i]);
            }
            root=ref;

        }
        return ref;


    }

}
