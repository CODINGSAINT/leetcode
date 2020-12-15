package dynamicprogramming;

public class CountSquareSubmatriceswithAllOnes {
        public int countSquares(int[][] matrix) {
            int rows=matrix.length;
            int cols=matrix[0].length;
            // int dp[][]=new int[m][n];
            int count=0;

            for(int col=0;col<matrix[0].length;col++){
                if(matrix[0][col]==1) count++;
            }
            for(int i=1;i<matrix.length;i++){
                if(matrix[i][0]==1)
                    count++;
            }

            for(int row=1;row<matrix.length;row++){
                for(int col=1;col<matrix[0].length;col++){
                    if(matrix[row][col] != 0){
                        int min= 1+ Math.min(matrix[row-1][col-1] ,
                                Math.min(matrix[row][col-1],   matrix[ row -1][col] ));
                        count+=min;
                        matrix[row][col]=min;

                    }

                }
            }
            return count;
        }
    }
