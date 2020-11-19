package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=48,
url = "https://leetcode.com/problems/rotate-image/",
level = Level.MEDIUM,
title = "Rotate Image")
public class RotateImage {

    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for (int j = i; j < n - i - 1; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]= matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }

    }
}