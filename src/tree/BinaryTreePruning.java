package tree;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=814, title = "Binary Tree Pruning",url = "https://leetcode.com/problems/binary-tree-pruning/",level = Level.MEDIUM)
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null)
            return null;

        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);

        if(root.val==0){
            if(root.left==null && root.right==null)
                return null;
        }
        return root;



    }
}
