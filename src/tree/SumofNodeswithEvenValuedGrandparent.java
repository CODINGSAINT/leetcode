package tree;
//|1315| [Sum of Nodes with Even-Valued Grandparent](https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/) | Medium | [SumofNodeswithEvenValuedGrandparent](https://github.com/CODINGSAINT/leetcode/blob/master/src/linkedlist/SumofNodeswithEvenValuedGrandparent.java) |
public class SumofNodeswithEvenValuedGrandparent {
    Integer sum = 0;

    public static void main(String[] args) {
        TreeNode t = new TreeNode(6);
        t.left = new TreeNode(7);
        t.left.left = new TreeNode(2);
        t.left.left.left = new TreeNode(9);

        t.left.right = new TreeNode(7);
        t.left.right.left = new TreeNode(1);
        t.left.right.right = new TreeNode(4);


        t.right = new TreeNode(8);
        t.right.left = new TreeNode(1);
        t.right.right = new TreeNode(3);
        t.right.right.right = new TreeNode(5);

        SumofNodeswithEvenValuedGrandparent s = new SumofNodeswithEvenValuedGrandparent();
        s.sumEvenGrandparent(t);

    }
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        grandParentSum(root);
        return sum;
    }

    void grandParentSum(TreeNode t) {
        if (t != null) {
            if (t.val % 2 == 0) {
                TreeNode left = t.left;
                if (t.left != null) {
                    if (t.left.left != null) {
                        sum += t.left.left.val;
                    }
                    if (t.left.right != null) {
                        sum += t.left.right.val;

                    }
                }
                if (t.right != null) {
                    if (t.right.left != null) {
                        sum += t.right.left.val;
                    }
                    if (t.right.right != null) {
                        sum += t.right.right.val;
                    }
                }
            }

            grandParentSum(t.left);
            grandParentSum(t.right);
        }

    }

}


