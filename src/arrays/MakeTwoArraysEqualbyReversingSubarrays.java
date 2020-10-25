package arrays;

import java.util.Arrays;
//1460. Make Two Arrays Equal by Reversing Sub-arrays
//https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
public class MakeTwoArraysEqualbyReversingSubarrays {

    //O(n)
    public boolean canBeEqualOptimized(int[] target, int[] arr) {
        // Base Case Check
        if (target.length != arr.length){
            return false;
        }
        int[] freq = new int[1001];
        for (int i = 0 ; i < target.length ; i++){
            freq[target[i]]++;
            freq[arr[i]]--;
        }

        for (int i : freq){
            if (i != 0){
                return false;
            }
        }
        return true;
    }
    //nlogn
    public boolean canBeEqual(int[] target, int[] arr) {
        if(arr.length!=target.length) return false;
        Arrays.sort(arr);
        Arrays.sort(target);
        for(int i=0;i<target.length;i++){
            if(arr[i]!=target[i])
                return false;

        }
        return true;

    }
}
