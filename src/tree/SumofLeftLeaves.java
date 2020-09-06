package tree;
//404 Sum of Left Leaves
//https://leetcode.com/problems/sum-of-left-leaves/
public class SumofLeftLeaves {
    public static void main(String[] args) {
        TreeNode t= new TreeNode(3);
        t.left= new TreeNode(9);
        t.right= new TreeNode(20);
        t.right.left=new TreeNode(15);
        t.right.right=new TreeNode(7);
        SumofLeftLeaves s= new SumofLeftLeaves();
        System.out.println(s.sumOfLeftLeaves(t));


    }
    public int sumOfLeftLeaves(TreeNode root) {
        int total=0;
        if(root==null ||( root.left==null && root.right == null) )
            return 0;


        total= sum(root,total,true);
        return total;

    }
    public int sum(TreeNode root,int total,boolean isLeft){
        if(root!=null){
            if(root.left==null && root.right==null && isLeft)
                total+=root.val;

            total=sum(root.left,total,true)  ;
            total= sum(root.right,total,false)  ;
        }
        return total;

    }
}
