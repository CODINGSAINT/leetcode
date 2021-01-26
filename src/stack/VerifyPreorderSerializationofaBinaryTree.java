package stack;

import java.util.Stack;
//331. Verify Preorder Serialization of a Binary Tree M
//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        Stack<String> st= new Stack<>();
        String preOrderArray[]=preorder.split(",");
        for(int i=0;i<preOrderArray.length;i++){
            String current=preOrderArray[i];

            while(st.size()>0 && current.equals("#") && st.peek().equals("#")){
                st.pop();
                if(st.isEmpty()) return false;
                st.pop();

            }

            st.add(current);

        }
        return  st.peek().equals("#") && st.size()==1;
    }
}
