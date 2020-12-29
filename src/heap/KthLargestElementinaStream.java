package heap;

import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@LeetCode(no=703, title="Kth Largest Element in a Stream" ,url = "https://leetcode.com/problems/kth-largest-element-in-a-stream/", level = Level.EASY)
public class KthLargestElementinaStream {
}
class KthLargest {
    int k;
    PriorityQueue<Integer>q;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        q= new PriorityQueue<Integer>();
        for(int i: nums){
            q.offer(i);
        }

    }

    public int add(int val) {
        q.offer(val);
        int i=1;
        List<Integer> temp= new ArrayList<>();
        while(q.size()>k){
            q.poll();
        }
        return q.peek();
    }
}