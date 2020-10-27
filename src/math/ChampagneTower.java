package math;

import utils.LeetCode;
import utils.Level;

@LeetCode(
        no= 799,
        level = Level.MEDIUM,
        title = "Champagne Tower",
        url = "https://leetcode.com/problems/champagne-tower/"
)
//TODO Revisit good math question , try solving bootup
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] rc = new double[101][101];
        rc[0][0] = poured;

        for (int row=0; row<=query_row; row++) {

            for (int col=0; col<=row; col++) {
                double output = (rc[row][col]-1.0)/2;

                if (output > 0) {
                    rc[row+1][col] += output;
                    rc[row+1][col+1] += output;
                }
            }
        }

        return Math.min(1,rc[query_row][query_glass]);
    }

}
