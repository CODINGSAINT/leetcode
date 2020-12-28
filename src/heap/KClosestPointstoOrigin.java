package heap;

import utils.LeetCode;
import utils.Level;

import java.util.*;


@LeetCode(no = 973, title = "K Closest Points to Origin", level = Level.MEDIUM, url = "https://leetcode.com/problems/k-closest-points-to-origin/"
)
public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        //√[(x₂ - x₁)² + (y₂ - y₁)²
        PriorityQueue<Point> q = new PriorityQueue<>((a, b) -> (int) (
                (Math.pow((0 - a.x), 2) + Math.pow((0 - a.y), 2))
                        - (Math.pow((0 - b.x), 2) + Math.pow((0 - b.y), 2))


        )
        );

        for (int i[] : points) {
            q.offer(new Point(i[0], i[1]));

        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point p = q.poll();
            int point[] = {p.x, p.y};
            result[i] = point;
        }
        return result;
    }

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}