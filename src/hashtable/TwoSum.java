package hashtable;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        //Add to target
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sol = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //Check if corrosponsding value is not null
            Integer corros = map.get(target - num);
            if (corros != null) {
                sol[0] = corros;
                sol[1] = i;
            }
            map.put(num, i);

        }
        return sol;
    }
}
