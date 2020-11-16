package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;

@LeetCode(
        no=1637,
        title = "Widest Vertical Area Between Two Points Containing No Points",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/"
)
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a, b)->  a[0]-b[0]);
        int maxDistance=0;
        for(int i=1;i<points.length;i++ ){
            if(points[i][0] != points[i-1][0]){
                maxDistance=Integer.max(maxDistance,(points[i][0] -points[i-1][0] ) );
            }
        }
        return maxDistance;

    }

}
