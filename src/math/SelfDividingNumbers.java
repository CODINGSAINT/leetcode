package math;

import java.util.*;
//728. Self Dividing Numbers (https://leetcode.com/problems/self-dividing-numbers/)
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res= new ArrayList<>();
        for(int i=left;i<=right;i++){

            int temp=i;
            boolean self=true;
            while(temp!=0){
                int curr=temp%10;
                if(curr==0 || i%curr !=0){
                    self=false;
                    break;
                }
                temp=temp/10;
            }


            if(self)
                res.add (i);
        }

        return res;

    }
}
