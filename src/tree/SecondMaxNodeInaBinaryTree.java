package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// |671| [Second Minimum Node In a Binary Tree](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/) | Easy | [SecondMaxNodeInaBinaryTree](https://github.com/CODINGSAINT/leetcode/blob/master/src/tree/SecondMaxNodeInaBinaryTree.java)|
public class SecondMaxNodeInaBinaryTree {
      public static void main(String[] args) {
        TreeNode t= new TreeNode(2);
        t.left= new TreeNode(2);
t.right= new TreeNode(5);
t.right.left=new TreeNode(5);
t.right.right= new TreeNode(7);
        SecondMaxNodeInaBinaryTree s= new SecondMaxNodeInaBinaryTree();
        System.out.println(s.findSecondMinimumValue(t));
    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        int min= root.val;
        List<Integer> allVals= new ArrayList();
        preorder(root,allVals);
        Collections.sort(allVals);
        return allVals.size()<2?-1:allVals.get(1);

    }
    void preorder(TreeNode t,  List<Integer> allVals){
        if(t!=null){
            if(!allVals.contains(t.val))
                allVals.add(t.val);
            preorder(t.left, allVals);
            preorder(t.right, allVals);

        }

    }
}
