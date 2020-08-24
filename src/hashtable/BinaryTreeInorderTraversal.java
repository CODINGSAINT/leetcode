package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
  Definition for a binary tree node.**/
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        Stack<TreeNode> s= new Stack<>();
        TreeNode currentNode=root;
        Boolean done = false;
        while(!done){
            if(currentNode!=null){
                s.push(currentNode);
                currentNode=currentNode.left;
            }else{
                if(s.isEmpty()){
                    done =true;
                }else{
                    currentNode= s.pop();
                    res.add(currentNode.val);
                    currentNode=currentNode.right;
                }

            }
        }
        return res;
    }
}
