package arrays;
import java.util.*;
//1329. Sort the Matrix Diagonally
public class SorttheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length;
        //row wise
        int rows=m;
        int columns=mat[0].length;
        for(int i=0;i<m ;i++){
            int temp=i;
            int n=mat[i].length;
            int j=0;
            List<Integer> value= new ArrayList<>();
            while(i<m && j<n){
                value.add(mat[i][j]);
                i++;j++;
            }
            Collections.sort(value);
            i=temp;
            j=0;
            int index=0;
            while(i<m && j<n){
                mat[i][j]=value.get(index);
                index++;
                i++;j++;
            }
            i=temp;

        }

        for(int j=1;j<columns; j++){
            int row=0;
            int temp=j;
            List<Integer> value= new ArrayList<>();
            while(j<columns&& row<m){
                value.add(mat[row][j]);
                row++;
                j++;

            }
            Collections.sort(value);
            row=0;
            j=temp;
            int  index=0;
            while(j<columns&& row<m){
                mat[row][j]=value.get(index);
                row++;
                j++;
                index++;

            }
            //row=0;
            j=temp;

        }


        return mat;
    }


}
