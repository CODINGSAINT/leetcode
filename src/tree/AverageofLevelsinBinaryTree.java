package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public static void main(String[] args) {
        //
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res= new ArrayList<>();
        List<Integer> values= new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q= new LinkedList();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()) {
            TreeNode tmp=q.poll();

            if(tmp!=null){
                values.add(tmp.val);
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }

                if(tmp.right!=null){
                    q.offer(tmp.right);
                }
            } else{
                double sum=0;
                for(int i=0;i<values.size();i++){
                    sum+=(double)values.get(i);
                }
                res.add((double)sum/values.size());
                values.clear();
                if(!q.isEmpty()){
                    q.offer(null);

                }
            }
        }
        return res;

    }
}
