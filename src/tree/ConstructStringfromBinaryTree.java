package tree;

public class ConstructStringfromBinaryTree {
    int open=0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.right = new TreeNode(4);
        root.left.right = new TreeNode(3);

        ConstructStringfromBinaryTree c = new ConstructStringfromBinaryTree();
        System.out.println(c.tree2str(root));
    }

    public String tree2str(TreeNode t) {

        StringBuffer sb = new StringBuffer();

        preorder(t, sb);

        return sb.toString();
    }

    public void preorder(TreeNode t, StringBuffer sb) {
        sb.append(t.val);
        if(t.left != null) {
            sb.append("(");
            preorder(t.left, sb);
            sb.append(")");
        } else if(t.right != null) {
            sb.append("()");
        }
        if(t.right != null){
            sb.append("(");
            preorder(t.right, sb);
            sb.append(")");
        }

    }



}
