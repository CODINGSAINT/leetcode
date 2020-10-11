package arrays;

import java.util.Arrays;
//1051. Height Checker https://leetcode.com/problems/height-checker/
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int sortedArray[]= new int[heights.length];
        for(int i=0;i<heights.length;i++)
            sortedArray[i]=heights[i];
        Arrays.sort(sortedArray);
        int result=0;
        for(int i=0;i<heights.length;i++){
            if(sortedArray[i]!=heights[i])
                result++;
        }
        return result;
    }
}
