package linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        //
        ListNode l= new ListNode(1);
        l.next = new ListNode(2);
        l.next.next= new ListNode(2);
        l.next.next.next= new ListNode(1);
        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome(l));

    }
    public boolean isPalindrome(ListNode head) {
        ListNode current= head;
        int size=0;
        while(current!=null){
            size++;
            current= current.next;
        }
        boolean even=(size%2==0);

        int half= 0;
        if(even)
            half=size/2;
        else
            half=size/2 +1;
        current= head;
        int i=1;
        Stack<Integer> st= new Stack();
        while(current!=null){
            if(i<=half){
                if(!(!even && i==half)) {
                    st.push(current.val);
                }
            }

            else{
                if(st.peek() != current.val) {
                    return false;
                }
                st.pop();
            }
            current= current.next;
            i++;

        }
        return st.size()==0;
    }
}
