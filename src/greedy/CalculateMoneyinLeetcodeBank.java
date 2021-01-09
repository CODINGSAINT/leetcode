package greedy;

import utils.LeetCode;
import utils.Level;

@LeetCode(no =1716 ,
        level = Level.EASY ,
        title = " Calculate Money in Leetcode Bank",
        url="https://leetcode.com/problems/calculate-money-in-leetcode-bank/")
public class CalculateMoneyinLeetcodeBank {

    public int totalMoney(int n) {

        int money=0;
        int weekCounter=1;
        int current=1;
        for (int i = 1; i <= n; i++) {
            money+=current++;
            if(i%7==0){
                current=++weekCounter;
            }

        } return money;

    }
}
