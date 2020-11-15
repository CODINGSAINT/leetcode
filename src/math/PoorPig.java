package math;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=458,
 url = "https://leetcode.com/problems/poor-pigs/",
level = Level.HARD
,title = " Poor Pigs")
public class PoorPig {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int min = 0;
        int t = minutesToTest/minutesToDie;
        while (Math.pow(t+1,min) < buckets)
            min++;

        return min;
    }
}
