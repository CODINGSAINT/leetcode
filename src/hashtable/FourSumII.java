package hashtable;

import utils.LeetCode;
import utils.Level;

import java.util.HashMap;
import java.util.Map;
@LeetCode(no=452, url="https://leetcode.com/problems/4sum-ii/", level = Level.MEDIUM, title = "4Sum II")
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N=A.length;
        Map<Integer,Integer> sum= new HashMap<Integer,Integer>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int currsum=A[i]+B[j];
                sum.put(currsum, sum.getOrDefault(currsum,0)+1);
            }
        }

        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int currsum=C[i]+D[j];
                count+= sum.getOrDefault(-currsum, 0);
            }

        } return count;
    }
}
