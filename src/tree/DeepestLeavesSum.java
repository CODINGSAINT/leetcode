package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//|1302| [Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/) | Medium | [DeepestLeavesSum](https://github.com/CODINGSAINT/leetcode/blob/master/src/tree/DeepestLeavesSum.java) |
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null ) return 0;
        List<Integer> vals= new ArrayList();
        Queue<TreeNode> q= new LinkedList();
        List<List<Integer>> allVals= new ArrayList();
        TreeNode current = root;
        q.offer(current);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp= q.poll();
            if(temp!=null){
                vals.add(temp.val);
                if(temp.left!= null){
                    q.offer(temp.left);
                }
                if(temp.right != null ) {
                    q.offer(temp.right);
                }
            }
            else{
                List<Integer> levelVals= new ArrayList(vals);
                allVals.add(levelVals);
                vals.clear();
                if(!q.isEmpty()) {
                    q.offer(null);
                }
            }

        }
        List<Integer> lastLevel= allVals.get(allVals.size() -1);
        int sum =0;
        for(int i: lastLevel){
            sum+=i;
        }

       return sum;

    }
}
