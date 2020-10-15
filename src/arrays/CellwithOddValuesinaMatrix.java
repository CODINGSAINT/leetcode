package arrays;

public class CellwithOddValuesinaMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int totalOdd=0;
        int mat[][]=new int [n][m];
        for(int i=0;i<indices.length;i++){
            int row[] = indices[i];
            int r=row[0];
            int c=row[1];
            //increment row operation
            for(int j=0;j<mat[r].length;j++){
                mat[r][j]++;
            }
            for(int j=0;j<mat.length;j++){
                mat[j][c]++;
            }

        }
        for(int i=0;i<mat.length;i++){
            int row[]=mat[i];
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]%2!=0) totalOdd++;
            }
        }
        return totalOdd;
    }
}
