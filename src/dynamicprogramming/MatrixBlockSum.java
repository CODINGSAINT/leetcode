package dynamicprogramming;
//https://leetcode.com/problems/matrix-block-sum/
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int rows= mat.length;
        int cols= mat[0].length;

        int [][] prefixSum=new int[rows+1] [cols+1];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                prefixSum[i+1][j+1]+= mat[i][j]+
                        prefixSum[i][j+1] +
                        prefixSum[i+1][j] -
                        prefixSum[i][j];


            }

        }

        int result[][] = new int [rows][cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                int r1=Integer.max(0, row-K);
                int c1=Integer.max(0, col-K);

                int r2=Integer.min(rows-1, row+K);
                int c2=Integer.min(cols-1, col+K);

                result[row][col]= prefixSum[r2+1][c2+1] -prefixSum[r2+1][c1] -prefixSum[r1][c2+1] + prefixSum[r1][c1] ;

            }
        }
        return result;

    }
}

/*
1 2 3
4 5 6
7 8 9
0  0  0  0
0 12 21 16
0 27 45 33
0 24 39 28
*/


