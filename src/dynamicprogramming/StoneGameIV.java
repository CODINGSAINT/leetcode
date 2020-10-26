package dynamicprogramming;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 1510,
        title = "Stone Game IV",
        level = Level.HARD,
        url = "https://leetcode.com/problems/stone-game-iv/" )
public class StoneGameIV {
    public static void main(String[] args) {
        StoneGameIV s= new StoneGameIV();
        System.out.println(s.winnerSquareGame(4));
    }
    public boolean winnerSquareGame(int n) {
        if(n==1)
            return true;
        boolean dp[] = new boolean[n+1];
        for(int i=0;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                if(dp[i-j*j]==false){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
