package linkedlist;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 445,level = Level.MEDIUM,url = "https://leetcode.com/problems/add-two-numbers-ii/"
        ,title = "Add Two Numbers II")
//TODO without reversing
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        int carry=0;
        boolean first=true;
        ListNode sum=new ListNode();
        ListNode result=sum;
        while(l1!=null || l2!=null){
            int digit1= l1==null?0:l1.val;
            int digit2= l2==null?0:l2.val;
            int val =digit1+digit2+carry;
            carry=val/10;
            if(first){
                sum.val=val%10;
                first=false;
            }else{
                sum.next=new ListNode(val%10);
                sum=sum.next;
            }

            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;




        }
        if(carry>0){
            sum.next=new ListNode(carry);
        }
        ListNode finalRes = reverseList(result);
        return finalRes;

    }

    public ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode prev=null;
        while(current!=null){
            ListNode next=current.next;
            current.next= prev;
            prev=current;
            current= next;
        }
        return prev;
    }
}
