package slidingwindows;

import utils.LeetCode;
import utils.Level;

@LeetCode(no =1004,level = Level.MEDIUM,
        title = "Max Consecutive Ones III", url="https://leetcode.com/problems/max-consecutive-ones-iii/")
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int i=0;
        int j=0;


        while(i<A.length){
            if(A[i] ==0) K--;
            if(K<0){
                if(A[j]==0) {
                    K++;
                }
                j++;
            }


            i++;
        }
        return i-j;

    }
}

