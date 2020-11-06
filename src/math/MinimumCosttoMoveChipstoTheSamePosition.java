package math;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=1217,title = "Minimum Cost to Move Chips to The Same Position",level = Level.EASY,url = "https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/")
public class MinimumCosttoMoveChipstoTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int even=0;
        int odd =0;
        for(int x:position){
            if(x%2==0)
                even++;
            else
                odd++;
        }
        if(even==position.length|| odd==position.length)
            return 0;

        return Math.min(even,odd);



    }
}
