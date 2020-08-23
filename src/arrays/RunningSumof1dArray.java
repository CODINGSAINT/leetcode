package arrays;

public class RunningSumof1dArray {
    public static void main(String[] args) {

    }

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
                prev = res[i - 1];
            res[i] = prev + nums[i];
        }
        return res;

    }
}
