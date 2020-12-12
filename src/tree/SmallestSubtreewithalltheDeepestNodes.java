package tree;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 865, url = "https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/",level = Level.MEDIUM,title = "Smallest Subtree with all the Deepest Nodes")
public class SmallestSubtreewithalltheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null  ) return root;



        int left = height(root.left);
        int right = height(root.right);

        if(left == right)
            return root;
        else if(left < right)
            return subtreeWithAllDeepest(root.right);
        else
            return subtreeWithAllDeepest(root.left);

    }


    public int height(TreeNode node){
        if(node ==null) return 0;
        else return 1+ Integer.max(height(node.left), height(node.right));
    }

}
