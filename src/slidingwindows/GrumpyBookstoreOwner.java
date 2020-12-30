package slidingwindows;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=1052, title = "Grumpy Bookstore Owner", level = Level.MEDIUM,url = "https://leetcode.com/problems/grumpy-bookstore-owner/")
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied=0;
        int disappointed=0;
        //  int couldBeHappier=0;
        int max=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)
                satisfied+=customers[i];
            else
                disappointed+=customers[i];

            if(i>X)
                disappointed-=customers[i-X]*grumpy[i-X];

            max=Integer.max(max,disappointed)  ;

        }
        return satisfied+max;

    }
}
