package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        TreeNode current=root;

        Queue<TreeNode> q= new LinkedList();
        q.offer(current);
        q.offer(null);
        int level=1;

        while(!q.isEmpty()) {
            TreeNode temp= q.poll();
            if(temp!=null){
                if(temp.left == null && temp.right == null) {
                    return level;
                }
                if(temp.left!=null )
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);

            }else{
                level++;
                if(!q.isEmpty()) {
                    q.offer(null);
                }
            }

        }
        return level;
    }
}
