package arrays;

import java.util.Stack;

//| 1572 | [ Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/)|Easy| [MatrixDiagonalSum](https://github.com/CODINGSAINT/leetcode/blob/master/src/arrays/MatrixDiagonalSum.java)|
//
public class MatrixDiagonalSum {
    public static void main(String[] args) {

    }

    public int diagonalSum(int[][] mat) {
        int k = mat.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += mat[i][i];
            sum += mat[k - 1 - i][i];
        }

        if (k % 2 == 1) {
            sum -= mat[k / 2][k / 2];
        }

        return sum;
    }


}