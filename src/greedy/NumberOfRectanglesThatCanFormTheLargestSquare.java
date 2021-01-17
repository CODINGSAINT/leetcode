package greedy;

import java.util.HashMap;
import java.util.Map;
//1725. Number Of Rectangles That Can Form The Largest Square
public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public int countGoodRectangles(int[][] rectangles) {

        int length= rectangles.length;
        int largestResult[]=new int[length];
        int largest= Integer.MIN_VALUE;
        Map<Integer,Integer> freq= new HashMap<>();
        for (int i = 0; i < length; i++) {
            int []val= rectangles[i];
            largestResult[i]=Integer.min(val[0],val[1]);
            //System.out.println( largestResult[i]);

            largest=Integer.max(largest, largestResult[i]);
            freq.put(largestResult[i],freq.getOrDefault(largestResult[i],0)+1);
        }
        // System.out.println( largest);

        return freq.get(largest);


    }
}
