package greedy;

import java.util.Arrays;

public class BagofTokens {

    public int bagOfTokensScore(int[] tokens, int P) {
        int score=0;
        Arrays.sort(tokens);
        int low=0;
        int n=tokens.length-1;
        for(int i=0;i<=n;i++){
            if(P>=tokens[i]){
                score++;
                P-=tokens[i];

            }else if (i!=n && P<tokens[i] && tokens[n]>P && score>0) {
                P+=tokens[n];
                  score--;
                  n--;i--;
            }else {
                break;
            }
        }
        // System.out.println(P);
        return score;
    }
    public int bagOfTokensScoreOptimized(int[] tokens, int P) {
        Arrays.sort(tokens);
        int result=0;
        int S=0;
        for (int i=0,j=tokens.length-1;i<=j;) {
            if (P>=tokens[i]) {
                S++;
                P-=tokens[i++];
                result=Math.max(S, result);
                continue;
            }
            if (S>0) {
                S--;
                P+=tokens[j--];
            } else {
                break;
            }
        }
        return result;
    }
    }
}
