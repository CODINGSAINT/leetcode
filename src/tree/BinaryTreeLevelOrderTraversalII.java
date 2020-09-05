package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left= new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right= new TreeNode(3);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(7);
        BinaryTreeLevelOrderTraversalII b= new  BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> res=b.levelOrderBottom(root);
        res.stream().forEach(i->{
            i.stream().forEach(j-> System.out.print(j+" "));
            System.out.println();

        });
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=  new ArrayList();
        if(root== null)
            return res;
        TreeNode current=root;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        q.offer(null);
        List<Integer> curr= new ArrayList();
        while(!q.isEmpty()){
            TreeNode t= q.poll();
            if(t!=null) {
                curr.add(t.val);

                if(t.left != null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
            }else{
                ArrayList<Integer>c= new ArrayList(curr);
                res.add(0,c);
                curr.clear();
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }


        return res;

    }
}
