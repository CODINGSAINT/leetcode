package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=1304,
    title = "Find N Unique Integers Sum up to Zero",
    url = "https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/",
    level = Level.EASY)
public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] res=new int[n];

        int i=0;
        int st=1;
        if(n % 2 == 1){
            res[0]=0;
            i++;
        }
        while(i<n){
            res[i++]=st;
            res[i++]=st*-1;
            st++;
        }
        return res;
    }
}
