package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {

    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode current  = head;
        //All elements to arrayList
        List<Integer> elems =new ArrayList();
        while(current!= null){
            elems.add(current.val);
            current= current.next;
        }
        //
        return balancedBST(elems,0,elems.size()-1);

    }
    TreeNode balancedBST(List<Integer > elems, int start, int end){
        if(start>end)
            return null;

        int mid=(start+end)/2;
        TreeNode t= new TreeNode(elems.get(mid));
        t.left= balancedBST(elems , start, mid-1);
        t.right= balancedBST(elems , mid+1, end);
        return t;

    }
}
