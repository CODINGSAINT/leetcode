package linkedlist;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Step 1 : Add Numbers to stack to reverse it
        ListNode n1=l1;
        ListNode n2=l2;
        int carry=0;
        ListNode head=new ListNode();
        ListNode result=head;
        boolean first=true;
        while(n1!=null || n2!= null){
            int d1 =n1==null?0:n1.val;
            int d2 =n2==null?0:n2.val;
             int sum=carry+d1+d2;
            carry=sum/10;
              if(first){
                result.val=sum%10;
                first=false;
            }else{
                result.next=new ListNode(sum%10);
                result=result.next;
            }

            if(n1!=null) n1=n1.next;
            if(n2!=null) n2= n2.next;
        }if(carry>0)
            result.next= new ListNode(carry);

        return head;
    }
}

