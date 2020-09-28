package arrays;

import java.util.HashSet;

public class HappyNumber {
    HashSet<Integer> allNums = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        return valid(n);
    }

    boolean valid(int n) {
        boolean isHappy = false;
        if (n > 0) {
            if (n < 9) {
                allNums.add(n);
                return valid((int) n * n);
            }
            int sum = 0;
            while (n >= 1) {
                int r = n % 10;
                n = n / 10;
                sum += Math.pow(r, 2);
            }
            if (sum == 1) {
                return true;
            }
            if (allNums.contains(sum)) {
                return false;
            }
            n = sum;
            allNums.add(n);
            return valid(n);

        }
        return isHappy;

    }
}
