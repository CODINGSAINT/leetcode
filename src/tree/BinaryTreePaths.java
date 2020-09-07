package tree;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-paths/
//257 Binary Tree Paths
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode t= new TreeNode(1);
        t.left= new TreeNode(2);
        t.left.right= new TreeNode(5);

        t.right= new TreeNode(3);
        //t.right.right= new TreeNode(5);
        BinaryTreePaths b= new BinaryTreePaths();
        System.out.println( b.binaryTreePaths(t));
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths= new ArrayList<>();
        if(root!=null){
            inorder(root,paths,"",true,false);
        }
        return paths;
    }


    void inorder(TreeNode node, List<String>paths,String path ,boolean isLeft,boolean isRight){
        if(node!=null){
            path+=node.val+"->";

            if(isRight && node.left !=null)
                inorder(node.left,paths, new String(path),true,false);
            else
                inorder(node.left,paths, path,true,false);

            if(isLeft && node.right!=null)
                inorder(node.right,paths, new String(path),false,true);
            else
            inorder(node.right,paths, path,false,true);

        }
        if(node!=null &&node.left==null && node.right==null){

            paths.add(path.substring(0,path.length()-2));
        }
}
}
