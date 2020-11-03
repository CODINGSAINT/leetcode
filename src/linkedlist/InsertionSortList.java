package linkedlist;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 147,
        title = "Insertion Sort List",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/insertion-sort-list/")
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode fake = new ListNode(Integer.MIN_VALUE);
        ListNode prev = fake;
        while (temp != null) {
            if (prev.val > temp.val)
                prev = fake;
            while (prev.next != null && prev.next.val < temp.val)
                prev = prev.next;

            ListNode nextNode = temp.next;
            temp.next = (prev.next);
            prev.next = temp;
            temp = nextNode;
        }
        return fake.next;
    }
}
