package tree;

import java.util.LinkedList;
import java.util.Queue;

//|1161| [ Maximum Level Sum of a Binary Tree](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/) | Easy | [MaximumLevelSumofaBinaryTree](https://github.com/CODINGSAINT/leetcode/blob/master/src/tree/SecondMaxNodeInaBinaryTree.java)|
//
public class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root ==null) return 0;
        TreeNode current= root;
        Queue<TreeNode> q= new LinkedList();
        q.offer(current);
        q.offer(null);
        int maxSum=Integer.MIN_VALUE;
        int level=1;
        int maxSumLevel=0;
        int currentSum=0;
        while(!q.isEmpty()){
            TreeNode temp= q.poll();
            if(temp!=null){
                currentSum+=temp.val;

                if(temp.left!=null){q.offer(temp.left);}
                if(temp.right!=null){q.offer(temp.right); }
            }else{
                if(currentSum>maxSum){
                    maxSumLevel= level;
                    maxSum=currentSum;

                }
                if(!q.isEmpty()){
                    q.offer(null);
                }
                level++;
                currentSum=0;
            }
        }
        return maxSumLevel;

    }
}
