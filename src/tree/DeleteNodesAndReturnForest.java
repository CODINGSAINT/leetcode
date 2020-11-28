package tree;


import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. Delete Nodes And Return Forest
 * Medium
 *
 * 1451
 *
 * 48
 *
 * Add to List
 *
 * Share
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000
 */

/**
 * 111 / 111 test cases passed.
 * Status: Accepted
 * Runtime: 1 ms
 * Memory Usage: 39.5 MB
 */
@LeetCode(no = 1110,
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/delete-nodes-and-return-forest/",
        title = "Delete Nodes And Return Forest"
)
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) return nodes;
        Set<Integer> nodesToDelete = new HashSet<>();
        for (int i : to_delete) {
            nodesToDelete.add(i);
        }

        delNodes(root, nodesToDelete, nodes);
        if (!nodesToDelete.contains(root.val)) {
            nodes.add(root);
        }
        return nodes;
    }

    TreeNode delNodes(TreeNode node, Set<Integer> nodesToDelete, List<TreeNode> res) {
        if (node == null)
            return null;
        node.left = delNodes(node.left, nodesToDelete, res);
        node.right = delNodes(node.right, nodesToDelete, res);
        if (node != null) {
            if (nodesToDelete.contains(node.val)) {
                if (node.left != null)
                    res.add(node.left);
                if (node.right != null)
                    res.add(node.right);
                node = null;
            }
        }
        return node;
    }

}
