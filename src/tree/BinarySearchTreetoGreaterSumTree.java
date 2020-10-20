package tree;
// 1038. Binary Search Tree to Greater Sum Tree|https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class BinarySearchTreetoGreaterSumTree {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)return null;
        postOrder(root);
        return root;

    }
    void postOrder(TreeNode root) {
        if(root.right != null)
            postOrder(root.right);
        sum += root.val;
        root.val = sum;
        if(root.left != null)
            postOrder(root.left);
    }

}
