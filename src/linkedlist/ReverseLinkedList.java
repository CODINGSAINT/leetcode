package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode prev=null;
        while(current!=null){
            ListNode next= current.next;
            current.next = prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
