package linkedlist;
//24 Swap Nodes in Pairs
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesinPairs {
    public static void main(String[] args) {
        //
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode t=head;
        while(head!=null && head.next!=null){
            int temp= head.val;
            head.val= head.next.val;
            head.next.val=temp;
            head= head.next.next;
        }
        return t;


    }
}
