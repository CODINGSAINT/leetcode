package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
    public static void main(String[] args) {
        //
    }
    public List<Integer> preorder(Node root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        Stack<Node> st= new Stack<>();
        List<Integer> sol= new ArrayList<>();
        st.add(root);
        while(!st.isEmpty()){
            Node current=st.pop();
            sol.add(current.val);
            List<Node> childs= current.children;
            for(int i=childs.size()-1;i>=0;i--){
                Node n=childs.get(i);
                st.push(n);

            }

        }
        return sol;

    }
}
