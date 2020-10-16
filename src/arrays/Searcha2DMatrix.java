package arrays;
//74. Search a 2D Matrix
//https://leetcode.com/problems/search-a-2d-matrix/
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        boolean isPresent=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(j==0 && matrix[i][j] > target){
                    return isPresent;
                }
                if(matrix[i][j]== target){
                    return true;
                }

            }

        }

        return isPresent;

    }
}
