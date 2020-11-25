package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.*;

@LeetCode(no = 1222,
        title = "Queens That Can Attack the King",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/queens-that-can-attack-the-king/")
public class QueensThatCanAttacktheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        List<List<Integer>> attackPos = new ArrayList<>();
        int kingX = king[0];
        int kingY = king[1];

        Set<Pair> qPairs = new HashSet<>();
        Set<Pair> result = new HashSet<>();
        Pair p = null;
        for (int i = 0; i < queens.length; i++) {
            qPairs.add(new Pair(queens[i][0], queens[i][1]));
        }

        for (int i = kingY + 1; i <= 7; i++) {
            p = new Pair(kingX, i);
            if (qPairs.contains(p)) {
                result.add(p);
                break;
            }

        }

        for (int i = kingY - 1; i >= 0; i--) {

            p = new Pair(kingX, i);
            if (qPairs.contains(p)) {
                result.add(p);
                break;
            }

        }

        for (int i = kingX - 1; i >= 0; i--) {
            p = new Pair(i, kingY);
            if (qPairs.contains(p)) {
                result.add(p);
                break;
            }
            // vU.add(new Pair(i,kingY));
        }
        for (int i = kingX + 1; i <= 7; i++) {

            p = new Pair(i, kingY);
            if (qPairs.contains(p)) {
                result.add(p);
                break;
            }
        }
        int y = kingY;
        int x = kingX;
        while (y > 0) {
            p = new Pair(++x, --y);
            if (qPairs.contains(p)) {
                result.add(p);
                break;
            }
        }

        y = kingY;
        x = kingX;
        while (x > 0) {
            p = new Pair(--x, ++y);
            if (qPairs.contains(p)) {
                result.add(p);
                break;
            }
        }
        y = kingY;
        x = kingX;
        while (y > 0 && x > 0) {
            p = new Pair(--x, --y);
            if (qPairs.contains(p)) {
                result.add(p);
                break;
            }

        }

        y = kingY;
        x = kingX;
        while (y <= 7 && x <= 7) {
            p = new Pair(++x, ++y);
            if (qPairs.contains(p)) {
                result.add(p);
                break;
            }
        }

        for (Pair pair : result) {
            List<Integer> pos = new ArrayList<>();
            pos.add(pair.x);
            pos.add(pair.y);
            attackPos.add(pos);


        }

        return attackPos;
    }

    class Pair {
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}