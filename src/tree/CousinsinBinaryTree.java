package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinsinBinaryTree {
    public static void main(String[] args) {
        TreeNode t= new TreeNode(1);
        t.left= new TreeNode(2);
        t.left.right= new TreeNode(4);

        t.right= new TreeNode(3);
        t.right.right= new TreeNode(5);
        CousinsinBinaryTree c= new CousinsinBinaryTree();
        c.isCousins(t,4,5);
        
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        if(root== null)
            return false;
         Queue<TreeNode> q= new LinkedList();
        q.offer(root);
        q.offer(null);
        List<TreeNode> nodesAtLevel= new ArrayList();

        while(!q.isEmpty()) {
            TreeNode tmp=q.poll();

            if(tmp!=null) {
                nodesAtLevel.add(tmp);
                if(tmp.left!=null)
                    q.offer(tmp.left);

                if(tmp.right != null)
                    q.offer(tmp.right);

            }else{
                int present =0;
                // We have reached with all nodes at level
                for(int i=0;i<nodesAtLevel.size();i++){
                    TreeNode t= nodesAtLevel.get(i);
                    if((( t.right != null && t.right.val == x ) ||( t.left != null && t.left.val == x)) ||
                            (( t.right != null && t.right.val == y ) ||( t.left != null && t.left.val == y)) ){
                        present++;
                    }
                    if(present>1){
                        return true;
                    }

                }
                nodesAtLevel.clear();
                if(!q.isEmpty()) {
                    q.offer(null) ;
                }
            }


        }
        return false;
    }

}
