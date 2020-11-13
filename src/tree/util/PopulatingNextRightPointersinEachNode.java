package tree.util;


import utils.LeetCode;
import utils.Level;
import java.util.*;

@LeetCode(no=116,
title = "Populating Next Right Pointers in Each Node",
url = "https://leetcode.com/problems/populating-next-right-pointers-in-each-node/",
level = Level.MEDIUM)
public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if(root==null) return root;

        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Node>list= new ArrayList<>();
        while(!q.isEmpty()){
            Node tmp= q.poll();
            if(tmp!=null){
                list.add(tmp);
                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right!=null)
                    q.offer(tmp.right);

            }else{
                for(int i=1;i<list.size();i++){
                    list.get(i-1).next=list.get(i);
                }
                list.clear();
                if(!q.isEmpty()){
                    q.offer(null);
                }

            }

        }
        return root;

    }
}
