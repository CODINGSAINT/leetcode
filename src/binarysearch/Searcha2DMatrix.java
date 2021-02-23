package binarysearch;

public class Searcha2DMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {

        int rows= matrix.length;
        int cols=matrix[0].length;
        while(rows-1>0 && matrix[rows-1][0]>target){
            rows--;

        }
        for(int row=0;row<rows;row++){
            if(matrix[row][0]<=target && matrix[row][cols-1]>=target){
                boolean found=find(matrix[row],target);
                if(found)
                    return true;
            }
        }
        return false;

    }
    boolean find(int nums[],int target){
        int st=0;
        int end=nums.length-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            int m=nums[mid];
            if(m==target||nums[st]==target||nums[end]==target){
                return true;
            }
            else if(m<target){
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}
