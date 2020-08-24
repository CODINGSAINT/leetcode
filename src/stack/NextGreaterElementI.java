package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElementI {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> secondArrayMap = new HashMap<>();
        Stack<Integer> solStack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            secondArrayMap.put(i, nums2[i]);
        }
        int currentHigest = 0;
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            if (currentHigest > n) {
                currentHigest = n;
            }
            for (int j = i; j < nums2.length; j++) {
                int n2 = secondArrayMap.get(j);
                boolean foundGreaterElement = false;
                if (n2 > currentHigest) {
                    solStack.push(n2);
                    foundGreaterElement = true;
                    break;
                }
                if (!foundGreaterElement) {
                    solStack.push(-1);
                }
            }
        }

        int sol[] = new int[nums1.length];
        int totalSolutionElement = nums1.length;
        while (totalSolutionElement != 0) {
            if (!solStack.isEmpty()) {
                sol[totalSolutionElement - 1] = solStack.pop();
            }
            totalSolutionElement--;
        }
        return sol;
    }
}
