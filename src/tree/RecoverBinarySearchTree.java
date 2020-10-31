package tree;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 99,
        level = Level.HARD,
        title = "Recover Binary Search Tree",
        url = "https://leetcode.com/problems/recover-binary-search-tree/")
public class RecoverBinarySearchTree {
    TreeNode curr;
    TreeNode nodeToReplace1, nodeToReplace2;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        inOrder(node);
        if (nodeToReplace1 != null && nodeToReplace2 != null) {
            int temp = nodeToReplace1.val;
            nodeToReplace1.val = nodeToReplace2.val;
            nodeToReplace2.val = temp;
        }
    }

    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);

            if (curr != null) {
                if (curr.val > node.val) {
                    if (nodeToReplace1 == null) {
                        nodeToReplace1 = curr;
                    }
                    nodeToReplace2 = node;
                }
            }
            curr = node;
            inOrder(node.right);

        }

    }
}
