package arrays;

public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int steps=0;
        for(int i=1;i<points.length;i++){
            steps+=Math.max( Math.abs(points[i-1][0]-points[i][0]),Math.abs(points[i-1][1]-points[i][1]) );

        }
        return steps;

    }
}
