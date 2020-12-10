package arrays;
import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        int mat[][]={{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix s= new SpiralMatrix();
        System.out.println(s.spiralOrder(mat));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        //L,R,D,U
        List<Integer> list= new ArrayList<>();

        char direction ='R';
        int m=matrix.length;
        int n= matrix[0].length;
        if(m==1 && n==1){
            list.add(matrix[0][0]);
            return list;
        }
        int totalElement=m*n;
        int row=0;int col=0;
        int rowM=m-1;
        int colM=n-1;
        int rowB=0;
        int colB=0;
        int st=0;
        while(st!=totalElement){
            if( col==colM && direction=='R'){
                direction='D';
                --colM;
            }else if(row==rowM && direction=='D'){
                direction='L';
                --rowM;
            }
            else if(direction=='L' && col==colB){
                direction='U';
                colB++;
            }else if(direction=='U' &&  row==rowB+1){
                direction='R';
                rowB++;
            }

            if(direction=='R'){
                list.add(matrix[row][col++]);

            }else if(direction=='L'){

                list.add(matrix[row][col--]);

            }else if(direction=='U'){
                list.add(matrix[row--][col]);

            }else if(direction=='D'){
                list.add(matrix[row++][col]);
            }
            //System.out.println(direction+"->"+list);
            st++;
        }
        return list;
    }
}
