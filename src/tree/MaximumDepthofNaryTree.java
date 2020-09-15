package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        Node node= root;
        int depth=1;
        Queue<Node> q= new LinkedList();
        q.offer(node);
        q.offer(null);
        while(!q.isEmpty()){
            Node temp= q.poll();
            if(temp!=null){
                for(Node t: temp.children){
                    q.offer(t);
                }
            }else{
                if(!q.isEmpty()) {
                    depth++;
                    q.offer(null);
                }

            }
        }
        return depth;

    }
}
