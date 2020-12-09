package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.List;

@LeetCode(no = 448,
        level = Level.EASY,
        url = "https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/",
        title = "Find All Numbers Disappeared in an Array")

public class FindAllNumbersDisappearedinanArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> vals = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]) * -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                vals.add(i + 1);
        }

        return vals;

    }
}
