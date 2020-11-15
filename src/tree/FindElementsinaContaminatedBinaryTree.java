package tree;

import utils.LeetCode;
import utils.Level;

import java.util.HashSet;
import java.util.Set;
//1261. Find Elements in a Contaminated Binary Tree
@LeetCode(no=1261,title = "1261. Find Elements in a Contaminated Binary Tree",level = Level.MEDIUM,url = "https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/")
public class FindElementsinaContaminatedBinaryTree {
}
class FindElements {

    TreeNode root;
    Set<Integer> vals;
    public FindElements(TreeNode root) {
        this.root=root;
        vals= new HashSet<>();

        root.val=0;
        vals.add(0);
        recover(root);


    }
    void recover(TreeNode node){
        if(node!=null){
            if(node.left!=null){
                node.left.val= 2*node.val +1;
                vals.add(node.left.val);
                recover(node.left);
            }
            if(node.right!=null){
                node.right.val= 2*node.val +2;
                vals.add(node.right.val);
                recover(node.right);
            }
        }

    }

    public boolean find(int target) {
        return vals.contains(target);

    }
}
