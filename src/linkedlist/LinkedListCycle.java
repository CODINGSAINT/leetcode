package linkedlist;

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        if (head == null) {
            return false;
        }
        ListNode fastPtr = head.next;
        while (slowPtr != null && fastPtr != null) {
            if (slowPtr == fastPtr) {
                return true;
            }
            slowPtr = slowPtr.next;
            if (fastPtr.next == null) {
                return false;
            }
            fastPtr = fastPtr.next.next;
        }
        return false;

    }

}
