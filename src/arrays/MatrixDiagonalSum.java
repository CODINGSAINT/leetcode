package arrays;

import java.util.Stack;

//| 1572 | [ Matrix Diagonal Sum](https://leetcode.com/problems/matrix-diagonal-sum/)|Easy| [MatrixDiagonalSum](https://github.com/CODINGSAINT/leetcode/blob/master/src/arrays/MatrixDiagonalSum.java)|
//
public class MatrixDiagonalSum {
    public static void main(String[] args) {

    }

    public int diagonalSum(int[][] mat) {
        int sum=0;
        int c=0;
        int row=0;
        while(row<mat.length){
            System.out.println(row+" "+c);
            sum+=mat[row++][c++];
        }
        row=0;
        c--;
        while(row<mat.length){
            sum+=mat[row++][c--];
        }
        if(mat.length%2!=0){

            int rm=mat.length/2;
            int cm=mat[0].length/2;
            // System.out.println(rm+" "+cm);
            sum-=mat[rm][cm];
        }
        return sum;
    }

}