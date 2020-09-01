package tree;

import java.util.LinkedList;
import java.util.Queue;

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
