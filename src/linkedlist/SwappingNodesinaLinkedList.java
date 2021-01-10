package linkedlist;

import utils.LeetCode;
import utils.Level;

@LeetCode(no =1721 ,
        level = Level.MEDIUM ,
        title = "Swapping Nodes in a Linked List",
        url="https://leetcode.com/problems/swapping-nodes-in-a-linked-list/")
public class SwappingNodesinaLinkedList {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;

        }

        ListNode nthFromBegin = head;

       ListNode nthFromLast=head;
        // 2) get the (len-n+1)th node from the beginning
        for (int i = 1; i < len - k + 1; i++)
            nthFromLast = nthFromLast.next;

        System.out.println("nthFromLast "+nthFromLast.val);

        for (int i = 1; i <=k-1; i++)
            nthFromBegin = nthFromBegin.next;
        System.out.println("nthFromBegin "+nthFromBegin.val);

        int tempVal= nthFromBegin.val;
        nthFromBegin.val=nthFromLast.val;
        nthFromLast.val=tempVal;

        return head;

    }

}
