package tree;

import utils.LeetCode;
import utils.Level;

@LeetCode(
        no=1026,
        title = "Maximum Difference Between Node and Ancestor",
        url = "https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/"
        ,level = Level.MEDIUM
)
public class MaximumDifferenceBetweenNodeandAncestor {
    int maxDiff=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root== null) return maxDiff;
        maxDiff=Integer.max(maxDiff(root,root.left,0),maxDiff(root,root.right,0) );
        if(root.left!=null){
            maxDiff=Integer.max(maxDiff,maxAncestorDiff(root.left));
        }  if(root.right!=null){
            maxDiff=Integer.max(maxDiff,maxAncestorDiff(root.right));
        }
        return maxDiff;
    }
    int maxDiff(TreeNode p, TreeNode c,int currentMax){

        if(c!=null){
            int max=Integer.max(currentMax,Math.abs(p.val- c.val));
            max=Integer.max(max, Integer.max(maxDiff(p,c.left,max),
                    maxDiff(p,c.right,max) ));
            return max;
        }else{
            return currentMax;
        }



    }
}
