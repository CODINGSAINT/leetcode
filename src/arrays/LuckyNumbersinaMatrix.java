package arrays;

import java.util.ArrayList;
import java.util.List;
// |1380| [Lucky Numbers in a Matrix](https://leetcode.com/problems/lucky-numbers-in-a-matrix/)| Easy | (LuckyNumbersinaMatrix)(https://github.com/CODINGSAINT/leetcode/blob/master/src/arrays/LuckyNumbersinaMatrix.java)|
public class LuckyNumbersinaMatrix {
    public static void main(String[] args) {

        int mat[][] = { { 3,7,8},
                { 9,11,13},
                { 15,1,17} };
        LuckyNumbersinaMatrix l = new LuckyNumbersinaMatrix();
        l.luckyNumbers(mat);
    }
    public List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] <= smallest) {
                    smallest = matrix[i][j];
                    index = j;
                }
            }
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][index] > largest) {
                    largest = matrix[k][index];
                }
            }
            if (smallest == largest) {
                list.add(matrix[i][index]);
            }
            System.out.println("smallest " +smallest +"largest" +largest);

            largest = Integer.MIN_VALUE;
            smallest = Integer.MAX_VALUE;

        }
        return list;
}}
