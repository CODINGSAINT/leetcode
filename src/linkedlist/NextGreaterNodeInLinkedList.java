package linkedlist;

import java.util.*;

// 1019 https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNodeInLinkedList {
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

  /*  public int[] nextLargerNodes(ListNode head) {
        int len=0;
        ListNode current= head;
        Map<Integer,Integer> nextMap=new HashMap<>();
        Stack<Integer> s1= new Stack<>();
        Stack<Integer> s2= new Stack<>();

        while(current!=null){
            while(!s1.isEmpty() && s1.peek()<current.val){
               s2.push(current.val);
               s1.pop();
            }
            s1.push(current.val);
            len++;
            current= current.next;
        }
        current= head;
        int res[]=new int[len];
        int i=0;
        while (current!=null){
            res[i]= nextMap.getOrDefault(current.val,0);
            current=current.next;
            i++;
        }
        return res;
    }*/


}
