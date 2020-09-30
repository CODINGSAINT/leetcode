package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rv= new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        List<Integer>vals= new ArrayList();
        if(root!=null){
            q.offer(root) ;
            q.offer(null);
            while(!q.isEmpty()) {
                TreeNode tmp= q.poll();
                if(tmp!=null){
                    vals.add(tmp.val);
                    if(tmp.left!=null)
                        q.offer(tmp.left) ;
                    if(tmp.right!=null)
                        q.offer(tmp.right);
                }else{
                    //Level is reached
                    rv.add(vals.get(vals.size()-1));
                    vals.clear();
                    if(!q.isEmpty())
                        q.offer(null);
                }
            }
        }

        return rv;
    }
}
