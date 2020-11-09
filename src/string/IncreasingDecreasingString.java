package string;

import utils.LeetCode;
import utils.Level;

@LeetCode(
        no=1370,
        title = "Increasing Decreasing String",
        level = Level.EASY,
        url = "Increasing Decreasing String"
)
public class IncreasingDecreasingString {

    public String sortString(String s) {
        int []freq = new int[26];
        StringBuffer sb= new StringBuffer();
        for(int c:s.toCharArray()){
            freq[c-'a']++;
        }

        boolean allUsed=false;
        boolean isIncreasing=true;
        while(!allUsed){
            int zeroCount=0;
            if(isIncreasing){
                for(int i=0;i<freq.length;i++){

                    if(freq[i]!=0){
                        sb.append((char)(i+'a'));
                        freq[i]--;
                    }
                    if(freq[i]==0)
                        zeroCount++;
                }

            }
            if(!isIncreasing){
                for(int i=freq.length-1;i>=0;i--){
                    if(freq[i]!=0){
                        sb.append((char)(i+'a'));
                        freq[i]--;
                    }
                    if(freq[i]==0)
                        zeroCount++;
                }
            }
            if(zeroCount==26){
                allUsed=true;
            }
            isIncreasing=!isIncreasing;

        }
        // System.out.println(sb.toString());
        return sb.toString();

    }
}
