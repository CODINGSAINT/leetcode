package dynamicprogramming;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;

@LeetCode(no =416,
        title="Partition Equal Subset Sum",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/partition-equal-subset-sum/"
)
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        //Arrays.sort(nums);
        int sum= Arrays.stream(nums).sum();
        int n=nums.length;
        if(sum%2!=0) return false;
        int half=sum/2;
        return knapSack(nums,half);

    }
    boolean knapSack(int arr[],int required){
        int n=arr.length;
        boolean [][] result= new boolean[required+1] [n+1];

        // There are elements but required value is  0
        for(int i=0;i<=n;i++){
            result[0][i]=true;
        }
        // requuired value is not zero but there is nothing to be e=included
        for(int i=1;i<=required;i++){
            result[i][0]=false;
        }

        for(int sum=1;sum<=required;sum++){
            for(int no=1; no<=n;no++){
                // Two possible scenario , include this number and get the value
                result[sum][no]=result[sum][no-1];

                if( sum >= arr[no-1] ){
                    //subset[i - set[j - 1]][j - 1];

                    result[sum][no]= result[sum][no] ||
                            result[sum-arr[no-1]][no-1];
                }




            }

        }
        return result[required][n];
    }


    /*
     * Time Limit Exceeds
     *
     */
    boolean possible(int nums[],int index ,int required ){
        //there are 2 possible options to achieve , either include the value at index or dont inclde the value
        if(required==0)
            return true;
        if(index==0)
            return false;

        if(nums[index-1]>required){
            return possible(nums, index-1, required);
        }


        return possible(nums,index-1, required) || possible(nums, index-1, required-nums[index]);
    }
}

