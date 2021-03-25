package binarysearch;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 1574,
        level = Level.MEDIUM,
        title = "Shortest Subarray to be Removed to Make Array Sorted",
        url = "https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/")
public class ShortestSubarraytobeRemovedtoMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
            low += 1;
        }
        if (low == arr.length - 1) {
            return 0;
        }


        while (low <= high && arr[high] >= arr[high - 1]) {
            high -= 1;
        }
        if (high == 0) {
            return arr.length - 1;
        }

        int result = Math.min(high, arr.length - low - 1);

        int i = 0;
        int j = high;

        while (i <= low && j < arr.length) {
            if (arr[j] >= arr[i]) {
                result = Math.min(j - i - 1, result);
                i += 1;
            } else {
                j += 1;
            }
        }
        return result;

    }

}