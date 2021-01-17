import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
       // int encoded
     //  System.out.println(Math.abs(Math.abs((6^4))));

        /*System.out.println(Math.abs(2-(Math.abs(~(1^2)))));
        System.out.println(Math.abs(3-(Math.abs(~(2^3)))));*/
       // System.out.println(~(2^3));
        //decode(new int[]{1,2,3},1);
        //decode(new int[]{6,2,7,3},4);

        Solution s= new Solution();
      //  System.out.println(s.tupleSameProduct(new int[]{2,3,4,6}));


        System.out.println(s.largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}}));



    }

    public int largestSubmatrix(int[][] matrix) {
        int col[]=new int[matrix[0].length];
        for (int i = 0; i < col.length; i++) {
            System.out.println(matrix[i][0]);
        }
        for (int i = 0; i < col.length; i++) {
            System.out.println(matrix[i][1]);
        }
        for (int i = 0; i < col.length; i++) {
            System.out.println(matrix[i][2]);
        }
        return  4;
    }
}
