package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.List;

@LeetCode(no = 228,
        level = Level.EASY,
        title = "Summary Ranges",
        url = "https://leetcode.com/problems/summary-ranges/")
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges s= new SummaryRanges();
        System.out.println(s.summaryRanges(new int []{0,2,3,4,6,8,9}));

    }

    public List<String> summaryRanges(int[] nums) {
        List<String>result=new ArrayList<>();
        if (nums.length==0) return result;
        int prev=nums[0];
        StringBuffer sb= new StringBuffer(String.valueOf(nums[0]));
        for(int i=1; i<nums.length;i++){
            System.out.println(nums[i]);
            if( prev!=nums[i] && prev+1 !=nums[i]){
                if(!sb.toString().equals(String.valueOf(prev)) ){
                    sb.append("->");
                    sb.append(String.valueOf(prev));
                }


                result.add(sb.toString());
                sb= new StringBuffer(String.valueOf(nums[i]));
                //  System.out.println(sb.toString());
            }
            prev=nums[i];
        }
        if(!sb.toString().equals(String.valueOf(prev)) ){
            sb.append("->");
            sb.append(String.valueOf(prev));
        }
        result.add(sb.toString());
        return result;


    }
}
