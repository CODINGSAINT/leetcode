package heap;
import java.util.*;
//1737 . Change Minimum Characters to Satisfy One of Three Conditions
public class FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int res=0;
        PriorityQueue<Integer>q= new PriorityQueue<>();
        int [][]resM= new int[matrix.length][matrix[0].length] ;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                if(col==0){
                    res=matrix[row][col];
                }
                else{
                    res=matrix[row][col]^resM[row][col-1];
                }

                resM[row][col]=res;

            }


        }
        for (int row = 1; row< matrix.length;row++) {
            for(int col=0;col<matrix[row].length;col++){

                resM[row][col] ^= resM[row-1][col];
            }
        }




        for(int row=0;row<resM.length;row++){
            for(int col=0;col<resM[row].length;col++){
                //  System.out.print(resM[row][col]+" ");
                q.add(resM[row][col]);
                while(q.size()>k)
                    q.remove();
            }
            //  System.out.println();
        }
        return q.peek();
    }
}
