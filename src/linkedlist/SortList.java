package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 148. Sort List https://leetcode.com/problems/sort-list/
//Todo Use MergeSort for O(1) space and ologn
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null)return head;
    List<Integer> vals= new ArrayList<>();
    ListNode node=head;
        while(node!=null){
        vals.add(node.val);
        node= node.next;
    }
        Collections.sort(vals);
    ListNode n=new ListNode();
    ListNode ret= n;
        for(int i=0;i<vals.size();i++){

        n.val=vals.get(i);
        if(i<vals.size()-1)
            n.next=new ListNode();
        n=n.next;
    }
        return ret;

}
}
