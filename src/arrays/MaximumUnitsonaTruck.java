package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;

@LeetCode(no = 1710,
        level = Level.EASY,
        title = "Maximum Units on a Truck",
        url = "https://leetcode.com/problems/maximum-units-on-a-truck/")
public class MaximumUnitsonaTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int max = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int i = 0; i < boxTypes.length; i++) {
            int boxes[] = boxTypes[i];
            int numberOfBoxes = boxes[0];
            int numberOfUnitsPerBox = boxes[1];

            if (numberOfBoxes <= truckSize) {
                max += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            } else if (numberOfBoxes > truckSize && truckSize > 0) {
                max += truckSize * numberOfUnitsPerBox;
                truckSize -= truckSize;
            }


        }
        return max;


    }
}
