package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=4,
        level = Level.HARD,
        url = "https://leetcode.com/problems/median-of-two-sorted-arrays/",
        title = "Median of Two Sorted Arrays")
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 1 & n2 == 1) {
            return (double) (nums1[0] + nums2[0]) / 2;
        }
        int result[] = new int[n1 + n2];
        int i = 0;
        int j = 0;
        for (int k = 0; k < result.length; k++) {
            if (i < n1 && j < n2) {
                if (nums1[i] < nums2[j]) {
                    result[k] = nums1[i];
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    result[k] = nums2[j];
                    j++;
                } else {
                    result[k] = nums1[i];
                    result[++k] = nums2[j];
                    i++;
                    j++;
                }

            } else if (i > n1 - 1) {
                result[k] = nums2[j];
                j++;
            } else if (j > n2 - 1) {
                result[k] = nums1[i];
                i++;
            }
        }

        int n = n1 + n2;

        if (n % 2 == 0) {

            return (double) (result[n / 2] + result[(n / 2) - 1]) / 2;
        } else
            return (double) result[n / 2];

    }
}
