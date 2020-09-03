package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/convert-bst-to-greater-tree/
public class ConvertBSTtoGreaterTree {
    public static void main(String[] args) {
        //
        TreeNode t= new TreeNode(3);
        t.left= new TreeNode(0);
        t.left.right=new TreeNode(2);
        t.left.right.left= new TreeNode(1);

        t.right=new TreeNode(4);
        ConvertBSTtoGreaterTree tbst= new ConvertBSTtoGreaterTree();
        TreeNode cnv= tbst.convertBST(t);
        System.out.println(cnv);
        Stack<TreeNode>st= new Stack();
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

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int rightSum = 0;
        while(node !=null || !stack.isEmpty()) {
            while(node !=null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += rightSum;
            rightSum =node.val;
            node = node.left;
        }
        return root;

    }
    /* public TreeNode convertBST(TreeNode root) {
            if(root==null)
                return root;

            List<Integer> vals= new ArrayList<>();
            TreeNode current= root;
            Stack<TreeNode>st= new Stack();
            st.push(current);

            while(!st.isEmpty()){
                TreeNode tmp= st.pop();
                vals.add(tmp.val);

                if(tmp.right!=null){
                    st.push(tmp.right);
                }
                if(tmp.left!=null){
                    st.push(tmp.left);
                }

            }
            current=root;

            st.push(current);

            while(!st.isEmpty()){
                TreeNode tmp= st.pop();
                tmp.val=findSum(tmp.val ,vals );
                if(tmp.left!=null){
                    st.push(tmp.right);
                }
                if(tmp.left!=null){
                    st.push(tmp.left);
                }

            }
            return root;

        }
        public int findSum(int val,  List<Integer> vals){
            int sum=val;
            for(int i:vals){
                if(i>val)
                    sum+=i;
            }
            return sum;

        }*/

    }
