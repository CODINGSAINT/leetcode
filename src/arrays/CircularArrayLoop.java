package arrays;
//https://leetcode.com/problems/circular-array-loop/

import utils.LeetCode;
import utils.Level;

@LeetCode(no =474 ,
        level = Level.MEDIUM ,
        title = "Circular Array Loop",
        url="https://leetcode.com/problems/circular-array-loop/")
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int slow=i;
            int fast=i;
            boolean forward=nums[i]>=0;

            do{
                slow=move(slow,forward,nums);
                fast=move(fast,forward,nums);
                if(fast!=-1)
                    fast=move(fast,forward,nums);
            }while(slow!=fast && slow!=-1 && fast!=-1);

            if(slow!=-1 && slow==fast)
                return true;
        }
        return false;
    }
    int move(int pos,boolean direction, int[] nums){
        boolean currentDirection=nums[pos]>=0;
        if(currentDirection!=direction)
            return -1;
        int newPos= (pos+nums[pos])%nums.length;
        if(newPos<0)
            newPos+=nums.length;
        if(newPos==pos)
            return -1;

        return newPos;

    }
}
