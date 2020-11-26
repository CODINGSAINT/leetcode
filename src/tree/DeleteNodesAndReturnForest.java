package tree;


import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@LeetCode( no=1110,
            level = Level.MEDIUM,
            url="https://leetcode.com/problems/delete-nodes-and-return-forest/",
             title = "Delete Nodes And Return Forest"
            )
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodes= new ArrayList<>();
        if(root==null) return nodes;
        Set<Integer> nodesToDelete= new HashSet<>();
        for(int i:to_delete){
            nodesToDelete.add(i);
        }

        delNodes(root, nodesToDelete, nodes);
        if(!nodesToDelete.contains(root.val)){
            nodes.add(root);
        }
        return nodes;
    }
    TreeNode delNodes(TreeNode node, Set<Integer> nodesToDelete, List<TreeNode> res){
        if(node==null)
            return null;
        node.left=delNodes( node.left,nodesToDelete,  res);
        node.right=delNodes( node.right, nodesToDelete, res);
        if(node != null){
            if(nodesToDelete.contains(node.val)){
                if(node.left!=null)
                    res.add(node.left);
                if(node.right!=null)
                    res.add(node.right);
                node=null;
            }
        }
        return node;
    }

}
