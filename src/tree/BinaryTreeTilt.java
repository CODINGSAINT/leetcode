package tree;
//563. Binary Tree Tilt
//https://leetcode.com/problems/binary-tree-tilt/
public class BinaryTreeTilt {
Integer currentSum=0;
    public static void main(String[] args) {
        TreeNode t= new TreeNode(1);
         t.left= new TreeNode(2);
         t.right= new TreeNode(3);
        t.left.left= new TreeNode(4);
        t.left.right= new TreeNode(5);
        BinaryTreeTilt b= new BinaryTreeTilt();
        System.out.println(b.findTilt(t));

    }
    public int findTilt(TreeNode root) {

        if(root!=null){
            int left= sumOfAllChild (root.left,currentSum);
            int right= sumOfAllChild (root.right,currentSum);
            currentSum+= Math.abs(left-right);
            findTilt(root.left);
            findTilt(root.right);


        }
        return currentSum;

    }

    private int sumOfAllChild(TreeNode node, int sum) {
        if(node==null){
            return sum;
        }
        sum+= node.val;
        sum =sumOfAllChild(node.left ,sum);
        sum =sumOfAllChild(node.right ,sum);
        return sum;
    }
}
