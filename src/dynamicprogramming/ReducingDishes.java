package dynamicprogramming;

import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        if(satisfaction[n-1] <0) return 0;
        int dp[]=new int[n];
       /* for(int x:satisfaction){
            System.out.print(x+" ");
        }*/
        boolean noNeg=true;
        // System.out.println();
        dp[n-1]=calulateSatisfaction(n-1,satisfaction );
        //System.out.print(dp[n-1]+" ");
        for(int i=n-2;i>=0;i--){
            dp[i]=calulateSatisfaction(i, satisfaction);
            // System.out.print(dp[i]+" ");
            if(dp[i]<dp[i+1]){
                noNeg=false;
                return dp[i+1];

            }
        }

        return noNeg?dp[0]:0;
    }

    int calulateSatisfaction(int start, int []satisfaction){
        int time=1;
        int s=0;
        for(int i=start;i<satisfaction.length;i++){
            s+=satisfaction[i]*time;
            time++;
        }
        return s;
    }
}
