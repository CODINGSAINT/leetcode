package tree;

import java.util.Stack;
//450. Delete Node in a BST https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeinaBST {
    public static void main(String[] args) {
        //
        TreeNode t= new TreeNode(5);
        t.left= new TreeNode(3);
        t.left.right=new TreeNode(4);
        t.left.left= new TreeNode(2);

        t.right=new TreeNode(6);

        t.right.right=new TreeNode(7);

        DeleteNodeinaBST d= new DeleteNodeinaBST();
        TreeNode cnv=d.deleteNode(t,3);
        Stack<TreeNode> st= new Stack();
        st.push(cnv);
        while(!st.isEmpty()){
            TreeNode tmp= st.pop();
            System.out.println((tmp.val));

            if(tmp.right!=null){
                st.push(tmp.right);
            }
            if(tmp.left!=null){
                st.push(tmp.left);
            }

        }

    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root!=null){
            if(key<root.val)
                root.left= deleteNode(root.left, key);
            if(key>root.val)
                root.right= deleteNode(root.right, key);
            if(key==root.val){


                if (root.left == null || root.right == null){
                    if(root.left != null){
                        return root.left;
                    }
                    if(root.right != null){
                        return root.right;
                    }
                    return null;
                }

                if(root.left!=null && root.right!=null){
                    //get the right Min
                    TreeNode tmp= smallest(root.right);
                    root.val= tmp.val;
                    root.right= deleteNode(root.right, root.val);


                }
            }

        }
        return root;

    }

    TreeNode smallest(TreeNode node) {
        while(node!=null && node.left!=null){
            node=node.left;
        }
        return node;
    }
}
