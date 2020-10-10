package sorting;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        //
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int position=points[0][1] ;
        int arrow=1;
        for(int i=1;i<points.length;i++) {
            if(points[i][0]<=position){
                continue;
            }
            arrow++;
            position= points[i][1];
        }
        return arrow;
    }
}
