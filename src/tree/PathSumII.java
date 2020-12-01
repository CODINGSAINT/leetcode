package tree;
import utils.LeetCode;
import utils.Level;

import java.util.*;

@LeetCode(no=113 ,title="Path Sum II" , level = Level.MEDIUM, url = "https://leetcode.com/problems/path-sum-ii/")
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths= new ArrayList<>();
        if(root==null)
            return paths;
        pathSum( root,  sum, new ArrayList<Integer>() ,  paths);
        return paths;

    }

    public void pathSum(TreeNode node, int sum, List<Integer>path, List<List<Integer>> paths){

        if(node!=null){
            path.add(node.val);
            if( node.left== null && node.right== null){
                int currentSum=path.stream().reduce(0,(a,b)->a+b);
                if(currentSum==sum)
                    paths.add(path);
            }

            if( node.left!= null && node.right!= null){
                pathSum( node.left,  sum, new ArrayList<Integer>(path),  paths);
                pathSum( node.right,  sum,  new ArrayList<Integer>(path),  paths);
            }else  if(node.left!= null)
                pathSum( node.left,  sum, path,  paths);
            else if(node.right!= null)
                pathSum( node.right,  sum, path,  paths);

        }

    }
}