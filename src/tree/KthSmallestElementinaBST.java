package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        List<Integer> list=new ArrayList<>();
        inOrder(root ,0,k,list);
        System.out.println(list);
        return list.get(k-1);

    }
    void inOrder(TreeNode node,int curr,int k, List<Integer> list){
        if(curr==k){
            return;
        } if(node!=null){

            curr=curr+1;
            inOrder(node.left,curr,k,list);
            list.add(node.val);

            inOrder(node.right,curr,k,list);
        }
    }
}
