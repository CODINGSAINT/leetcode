package dynamicprogramming;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0) return 0;
        Arrays.sort(envelopes,(x,y) ->
                (x[0] != y[0] ?x[0] - y[0]: y[1]-x[1]));

        int max=1;
        int dp[]= new int [envelopes.length+1 ];
        Arrays.fill(dp, 1);
        for(int i=1;i<envelopes.length; i++){
            for(int j=0;j<i;j++){

                if(envelopes[j][0] < envelopes[i][0] &&
                        envelopes[j][1] < envelopes[i][1] &&
                        dp[i] <dp[j]+1 ) {
                    dp[i]= dp[j]+1;
                    max= Integer.max(dp[i]   , max);
                }
            }
        }
        return max;
    }
}