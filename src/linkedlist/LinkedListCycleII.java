package linkedlist;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=142,
            level = Level.MEDIUM,
            title = "Linked List Cycle II",
            url = "https://leetcode.com/problems/linked-list-cycle-ii/")
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                slow=head;
                break;
            }

        }
        while(fast!=null && fast.next!=null){
            if(slow==fast) return slow;
            slow=slow.next;
            fast=fast.next;
        }
        return null;

    }
}
