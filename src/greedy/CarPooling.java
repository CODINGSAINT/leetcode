package greedy;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;

@LeetCode(no=1094 ,title = "Car Pooling",level = Level.MEDIUM,url = "https://leetcode.com/problems/car-pooling/")
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxDistance=Integer.MIN_VALUE;
        for(int i=0;i<trips.length;i++){
            maxDistance=Integer.max(maxDistance,trips[i][2]);
        }
        int[]vaccant=new int[maxDistance];

        Arrays.fill(vaccant,capacity);

        for(int i=0;i<trips.length;i++){
            int trip[]=trips[i];
            for(int j=trip[1];j<trip[2];j++){
                vaccant[j]-=trip[0];
                if(vaccant[j]<0)
                    return false;
            }

        }


        return true;
    }
}
