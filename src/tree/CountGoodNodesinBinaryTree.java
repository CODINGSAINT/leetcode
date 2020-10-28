package tree;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 1448,
        title = "Count Good Nodes in Binary Tree",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/count-good-nodes-in-binary-tree/")
public class CountGoodNodesinBinaryTree {
    Integer nodes=0;
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode temp=root;
        int val=temp.val;
        preOrder(temp,val);
        return nodes;
    }
    void preOrder(TreeNode node,int val){
        if(node!=null){
            if(node.val>=val){
                nodes++;
            }if(node.val>val){
                val=node.val;
            }
            preOrder(node.left, val);
            preOrder(node.right, val);

        }



    }
}
