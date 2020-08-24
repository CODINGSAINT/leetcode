package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
    //
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev=null;
        ListNode next =null;
        ListNode n = head;
        Set<Integer> nodes= new HashSet<>();
        while(n!=null) {
            ListNode curr= n;
            next= curr.next;

            boolean add= nodes.add(curr.val);

            if(!add){
                prev.next=next;
            }
            prev=curr;
            curr= curr.next;
            n= n.next;
        }
        return head;
    }

}
