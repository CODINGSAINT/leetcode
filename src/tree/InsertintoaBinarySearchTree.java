package tree;
//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertintoaBinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root!=null){
            if(val<root.val)
                root.left=insertIntoBST(root.left,val);
            if(val>root.val)
                root.right=insertIntoBST(root.right,val);

            return root;

        }else return
                new TreeNode(val);

    }

}
