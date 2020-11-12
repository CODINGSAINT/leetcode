package math;

import utils.LeetCode;
import utils.Level;

import java.util.HashSet;
import java.util.Set;

@LeetCode(
        no=593,
        url = "https://leetcode.com/problems/valid-square/",
        level = Level.MEDIUM,
        title = "Valid Square"
)
public class ValidSquare {
    public boolean validSquare(int[] a, int[] b, int[] c, int[] d) {


        Set<Integer> points = new HashSet<>();

        points.add(distanceOfTwoPoints(a,b));
        points.add(distanceOfTwoPoints(a,c));
        points.add(distanceOfTwoPoints(a,d));
        points.add(distanceOfTwoPoints(b,c));
        points.add(distanceOfTwoPoints(b,d));
        points.add(distanceOfTwoPoints(c,d));

        return !points.contains(0) && points.size() == 2;

    }
    int distanceOfTwoPoints(int []p1,int []p2) {
        return (
                (p1[0]-p2[0])*(p1[0]-p2[0])
                        + (p1[1]-p2[1])*(p1[1]-p2[1])
        );

    }

}
