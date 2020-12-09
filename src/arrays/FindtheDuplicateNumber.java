package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 287,
        title = "Find the Duplicate Number",
        url = "https://leetcode.com/problems/find-the-duplicate-number/",
        level = Level.MEDIUM)
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
