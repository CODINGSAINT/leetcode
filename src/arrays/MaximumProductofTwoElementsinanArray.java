package arrays;

public class MaximumProductofTwoElementsinanArray {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int i : nums) {


            if (i > max) {
                secMax = max;
                max = i;
            } else if (i > secMax)
                secMax = i;
        }


        return (max - 1) * (secMax - 1);
    }
}
