package misc;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberofStepstoReduceaNumbertoZero {
    public static void main(String[] args) {
       //
    }

    public int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            step++;
        }
        return step;

    }
}
