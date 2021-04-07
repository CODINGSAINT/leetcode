import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1000000007;
        int sum = 0;
        //Keep the PriorityQueue  to know the highest difference at peek and 
        // maxIndex which tells the index of the max abs difference element
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (pq.isEmpty() == false && diff > pq.peek())
                maxIndex = i;
            pq.add(diff);
            sum = (sum + diff) % MOD;
        }
        if (sum == 0) return 0;
        // the max difference should be reduced to get the result minimum absolute difference,
        // i.e. the index which provided the max difference needs to be replaced
        // such that it gives minimum possible value
        int currD = 0;
        // find the differences of all of the elements with the element at maxIndex and keep in another PriorityQueue 
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int i = 0; i < nums2.length; i++) {
            if (i != maxIndex) {
                currD = Math.abs(nums1[i] - nums2[maxIndex]);
                pq2.add(currD);
            }
        }
        //Now All we need to do is remove the max from pq1 and add the min of pq2 to sum,
        // both of which are at top of their respective q
        if (!pq2.isEmpty()) {
            if (!pq.isEmpty()) {

                sum -= pq.poll();
                sum = (sum + pq2.poll()) % MOD;
            }
        }

        return sum;
    }
}
