package tree;

import utils.LeetCode;
import utils.Level;

import java.util.LinkedList;
import java.util.Queue;

@LeetCode(no=104, url = "https://leetcode.com/problems/maximum-depth-of-binary-tree/", level = Level.EASY, title = "Maximum Depth of Binary Tree")
public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {

        int level=0;
        if(root!=null){
            Queue<TreeNode> q= new LinkedList<>();
            q.offer(root);
            q.offer(null);
            while(!q.isEmpty()){
                TreeNode tmp=q.poll();
                if(tmp!=null){
                    if(tmp.left!=null)
                        q.offer(tmp.left);
                    if(tmp.right!=null)
                        q.offer(tmp.right);
                }else{
                    level++;
                    if(!q.isEmpty()){
                        q.offer(null);
                    }
                }
            }
        }

        return level;
    }
}
