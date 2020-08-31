package tree;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
https://leetcode.com/problems/increasing-order-search-tree/
897 Increasing Order Search Tree
 Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

      5
     / \
   3    6
  / \    \
 2   4    8
/        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
           \
            7
             \
              8
               \
                9
    */
public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(5);
        root.left= new TreeNode(3);

        root.right= new TreeNode(6);
        root.left.left=new TreeNode(2);
        root.left.right= new TreeNode(4);
        root.left.left.left=new TreeNode(1);
        root.right.right= new TreeNode(8);
        root.right.right.left= new TreeNode(7);
        root.right.right.right= new TreeNode(9);

        IncreasingOrderSearchTree  i=new IncreasingOrderSearchTree();
        i.increasingBST(root);

    }

    public TreeNode increasingBST(TreeNode root) {
        if (root==null)
            return root;

        Stack<TreeNode> st= new Stack<>();
        TreeNode current=root;
        List<TreeNode> treeNodes= new ArrayList<>();
        boolean isDone = false;
        while (!isDone){
            if(current!=null){
                st.push(current);
                current=current.left;
            }else{
                if(st.isEmpty()){
                    isDone=true;
                }
                else{
                    current=st.pop();
                    treeNodes.add(current);
                    current=current.right;
                }
            }
        }
        TreeNode increaseOrder= treeNodes.get(0);
        TreeNode curr=increaseOrder;
        for(int i=1;i<treeNodes.size();i++){
            curr.left=null;
            curr.right=treeNodes.get(i);
            curr=curr.right;
        }
        return  increaseOrder;
    }
}
