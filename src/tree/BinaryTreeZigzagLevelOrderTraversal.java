package tree;

import java.util.*;
//103 Binary Tree Zigzag Level Order Traversal
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<Integer>curr= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>>allLvl= new ArrayList<>();
        boolean changeOrder= false;
        if(root!=null) {
            q.offer(root);
            q.offer(null);
            while(!q.isEmpty()) {
                TreeNode temp= q.poll();
                if(temp!=null){
                    curr.add(temp.val);
                    if(temp.left!= null)
                        q.offer(temp.left);
                    if(temp.right!=null)
                        q.offer(temp.right);


                }else{
                    //Level Reached
                    List<Integer>levelVals= new ArrayList(curr);
                    // System.out.println(changeOrder+":"+levelVals);
                    if(changeOrder){
                        Collections.reverse(levelVals);

                    }
                    allLvl.add(levelVals);
                    curr.clear();
                    changeOrder=!changeOrder;
                    if(!q.isEmpty())
                        q.offer(null);

                }
            }
        }
        return allLvl;

    }
}
