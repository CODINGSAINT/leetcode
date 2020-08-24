package linkedlist;

public class DeleteNodeinaLinkedList {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node) {
        node.val= node.next.val;
        ListNode temp= node.next;
        node.next= node.next.next;
        temp=null;

    }
}
