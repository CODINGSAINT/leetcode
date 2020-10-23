package dynamicprogramming;
//|123| [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
public class BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        int k=2;
        //if(prices.length==0 || k==0) return 0;
        int n=prices.length;
        if(k >n/2) {
            int maxProfit=0;
            for( int i = 1; i < n; i++ )
            {
                maxProfit += Math.max( 0, prices[ i ] - prices[ i - 1 ] );
            }

            return maxProfit;
        }

        int dp[][]= new int [k+1][n];
        for(int i=1;i<=k;i++){
            int maxProfit=-prices[0];
            for(int j=1;j<n;j++){



                dp[i][j]=Integer.max(  dp[i][j-1], (maxProfit+ prices[j]) );
                maxProfit=Integer.max( maxProfit, dp[i-1 ][j - 1] - prices[j]);

            }
        }
        return dp[k][n-1];

    }

}
