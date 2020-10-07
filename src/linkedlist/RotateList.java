package linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head== null) return head;
        int size=0;
        ListNode temp= head;
        ListNode lastNode = head;
        while(temp!=null){
            size++;
            temp=temp.next;
            if(lastNode.next!=null){
                lastNode= lastNode.next;
            }
        }
        k=k%size;
        if(size==1) return head;
        temp=head;
        ListNode node=head;
        int rotate=0;
        while(rotate<k){
            while(node.next!=null && node.next.next!=null){
                node= node.next;
            }
            node.next=null;
            lastNode.next=temp;
            temp=lastNode;
            lastNode=node;
            node=temp;

            rotate++;
        }
        return temp;

    }
}
