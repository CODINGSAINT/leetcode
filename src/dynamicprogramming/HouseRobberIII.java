package dynamicprogramming;

import tree.TreeNode;
import utils.LeetCode;
import utils.Level;

import java.util.HashMap;
import java.util.Map;

@LeetCode(no=337,
        title = "House Robber III",
        url = "https://leetcode.com/problems/house-robber-iii/",
        level = Level.MEDIUM)
public class HouseRobberIII {

    private Map<TreeNode, Integer> robbed = new HashMap<>();
    private Map<TreeNode, Integer> notRobbed = new HashMap<>();

    public int rob(TreeNode root) {
        if (root==null)return 0;
        return Integer.max(rob(root, true), rob(root,false));
    }

    private int rob(TreeNode node , boolean shouldRob){

        if(node==null) return 0;

        if(shouldRob){
            if(robbed.containsKey(node)){
                return robbed.get(node);
            }
            else{
                int total = node.val+ rob(node.left , !shouldRob)+  rob(node.right , !shouldRob);
                robbed.put(node, total);
                return total;
            }
        }else{
            if(notRobbed.containsKey(node)){
                return notRobbed.get(node);
            }
            else{
                int totalL =  Math.max(rob(node.left , shouldRob),rob(node.left , !shouldRob));
                int totalR =  Math.max(rob(node.right , shouldRob),rob(node.right , !shouldRob));
                int total= totalL+totalR;

                notRobbed.put(node, total);
                return total;
            }
        }
    }
}
