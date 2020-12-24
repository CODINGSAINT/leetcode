package dynamicprogramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1= text1.length();
        int n2= text2.length();
        int dp[][]= new int[n1+1][n2+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(text1.charAt(i-1)== text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1 ;
                }else{
                    dp[i][j]=Integer.max(dp[i][j-1], dp[i-1][j] );
                }
            }
        }

        /*
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
              System.out.print(dp[i][j]+"\t");
            }

              System.out.println();
        }
        */

        return dp[n1][n2];
    }
}
