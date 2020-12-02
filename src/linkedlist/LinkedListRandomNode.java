package linkedlist;

import utils.LeetCode;
import utils.Level;

import java.util.Random;

@LeetCode(no=382, title = "Linked List Random Node", url = "https://leetcode.com/problems/linked-list-random-node/",level = Level.MEDIUM
)
public class LinkedListRandomNode {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int size=0;
    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        ListNode node= head;
        this.head=head;
        while(node!=null){
            size++;
            node=node.next;
        }


    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random r = new Random();
        int low = 0;
        int high = size;
        int result = r.nextInt(high-low) + low;
        ListNode node= this.head;

        while(low!=result){
            low++;
            node= node.next;
        }
        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */