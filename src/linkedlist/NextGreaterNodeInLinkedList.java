package linkedlist;

import java.util.*;

// 1019 https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {

    }
       public int[] nextLargerNodes(ListNode head) {
        List<Integer> list= new ArrayList<>();
        ListNode current= head;
        while(current!=null){
            list.add(current.val);
            current=current.next;
        }
        int res[]=new int[list.size()];
        Stack<Integer> st = new Stack();
        for(int i=0;i<list.size();i++){
            while (!st.isEmpty() &&
                        list.get(st.peek())<list.get(i)){
                res[st.pop()]=list.get(i);
            }
            st.push(i);
        }
        return res;

    }

}
