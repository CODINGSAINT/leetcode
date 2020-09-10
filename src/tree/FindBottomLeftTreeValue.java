package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-bottom-left-tree-value/
//513. Find Bottom Left Tree Value
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {

    }
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;

        List<List<Integer>> allVals = new ArrayList();
        List<Integer> curr = new ArrayList();
        Queue<TreeNode> q= new LinkedList();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()) {
            TreeNode tmp= q.poll();
            if(tmp !=null){
                curr.add(tmp.val);
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }
                if(tmp.right !=null){
                    q.offer(tmp.right);
                }
            }else{
                allVals.add( new ArrayList(curr));
                curr.clear();
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
        return allVals.get(allVals.size()-1).get(0);


    }
}
