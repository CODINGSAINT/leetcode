package linkedlist;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 445,level = Level.MEDIUM,url = "https://leetcode.com/problems/add-two-numbers-ii/"
        ,title = "Add Two Numbers II")

public class AddTwoNumbersII {
    // Without Reversing

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null )return l2;
        if(l2==null) return l1;

        ListNode n1=l1;
        ListNode n2=l2;

        int size1=size(n1);
        int size2=size(n2);
        if(size1>size2){
            l2= addZeroNodes(size1-size2 , l2);
        }else if (size2>size1){
            l1= addZeroNodes(size2-size1, l1);
        }
        int remainder=add(l1,l2);

        if(remainder>0){
            ListNode remainderNode= new ListNode(remainder);
            remainderNode.next=l1;
            l1= remainderNode;
        }


        return l1;
    }
    int add(ListNode n1, ListNode n2){

        if(n1==null && n2==null) return 0;

        int remainder= add(n1.next, n2.next);
        n1.val+= n2.val+remainder;
        remainder = (int) (n1.val / 10);
        n1.val %= 10;
        return remainder;

    }
    ListNode addZeroNodes(int count,ListNode node){
        while(count >0){
            ListNode headNode = new ListNode (0);
            headNode.next= node;
            count--;
            node = headNode;
        }
        return node;
    }

    int size(ListNode node){
        int size=0;
        while(node!=null){
            size++;
            node= node.next;
        }
        return size;
    }
    ////////////////////////////////////////////////////////////


    //Reverse Linked List Solution
    public ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
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
