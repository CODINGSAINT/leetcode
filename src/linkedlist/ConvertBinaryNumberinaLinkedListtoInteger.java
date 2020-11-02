package linkedlist;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=1290,
        title = "Convert Binary Number in a Linked List to Integer" ,
        url = "https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/",
        level = Level.EASY)
public class ConvertBinaryNumberinaLinkedListtoInteger {

    public int getDecimalValue(ListNode head) {
        if(head==null) return 0;
        int number=0;
        ListNode node= head;
        while(node!=null){
            number=number*2+ node.val;
            node= node.next;
        }

        return number;
    }

    public int getDecimalValue_2(ListNode head) {
        if(head==null) return 0;
        ListNode node= head;
        StringBuffer sb= new StringBuffer();
        while(node!=null){
            sb.append(String.valueOf(node.val));
            node= node.next;
        }

        return Integer.parseInt(sb.toString(),2);
    }
}
