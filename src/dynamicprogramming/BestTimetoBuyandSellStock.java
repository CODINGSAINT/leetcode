package dynamicprogramming;
//|121| [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int min=prices[0];
        int max=prices[0];


        int  dp[] = new int[prices.length];
        dp[0]=0;
        for(int i=1;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i];
                max=prices[i];
            }
            if(max<prices[i]){
                max=prices[i];
            }

            dp[i]=Integer.max(dp[i-1] ,(max-min));

        }
        return dp[prices.length-1];
    }
}
