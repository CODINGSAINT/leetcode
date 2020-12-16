package greedy;

import java.util.Arrays;

public class SumofAbsoluteDifferencesinaSortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        //int s[][]= new int[n][n];
        int sum= Arrays.stream(nums).sum();
        int res[]=new int [n];
        int before=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int totalElementsBefore= i;
            int totalElementAfter=n-i-1;
            sum=sum-num;
            int val= sum - totalElementAfter*num;
            val+= totalElementsBefore*num-before;
            before+=num;
            res[i]=val;
        }
        return res;

    }
}
