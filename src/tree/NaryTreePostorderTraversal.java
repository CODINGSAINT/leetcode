package tree;

import java.util.*;
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/
//590. N-ary Tree Postorder Traversal
public class NaryTreePostorderTraversal {
    public static void main(String[] args) {
        List<Node> nodes= new ArrayList<>();
        Node n5= new Node(5);
        Node n6= new Node(6);
        nodes.add(n5);
        nodes.add(n6);

        Node node3= new Node(3);
        Node node4= new Node(2);
        Node node5= new Node(4);
        node3.children= nodes;
        nodes= new ArrayList<>();
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        Node node= new Node(1);
        node.children=nodes;
        NaryTreePostorderTraversal n= new NaryTreePostorderTraversal();
        n.postorder(node);

    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;
        Set<Node> nodeSet= new HashSet<>();
        Node current = root;
        Stack<Node> st = new Stack<>();
        st.push(current);
        Node prev = null;
        while (!st.isEmpty()) {
            current = st.peek();
            boolean added=nodeSet.add(current);

            List<Node> childs = current.children;
            if (added && childs != null && childs.size() > 0) {
                for (int i = childs.size()-1; i>=0 ; i--) {
                    Node n = childs.get(i);
                    st.push(n);
                }
            } else {
                res.add(st.pop().val);
            }

        }
        return res;
    }
}
