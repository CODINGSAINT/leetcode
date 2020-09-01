package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left= new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right= new TreeNode(3);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(7);
        BinaryTreeLevelOrderTraversal b= new  BinaryTreeLevelOrderTraversal();
        List<List<Integer>> res=b.levelOrder(root);
   res.stream().forEach(i->{
       i.stream().forEach(j-> System.out.print(j+" "));
       System.out.println();

   });
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null)
            return res;

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> levelList= new ArrayList<>();
        while (!q.isEmpty()){
            TreeNode tmp=q.poll();

            if(tmp!=null){
                levelList.add(tmp.val);

                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right!=null)
                    q.offer(tmp.right);
            }else{
                List<Integer> currLevel= new ArrayList<>(levelList);
                res.add(currLevel);
                levelList.clear();
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }


        }
        return res;
    }
}
