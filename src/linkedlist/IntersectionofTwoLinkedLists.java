package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> nodes= new HashSet<>();
        while(headA!=null){
            nodes.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(nodes.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
