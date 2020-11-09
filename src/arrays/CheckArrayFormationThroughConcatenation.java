package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@LeetCode(
        no=1640,
        title = " Check Array Formation Through Concatenation",
        url = "https://leetcode.com/problems/check-array-formation-through-concatenation/",
        level = Level.EASY
)
public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        boolean truth[]= new boolean[arr.length];
        Arrays.fill(truth,false);

        Map<Integer,Integer>pos= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            pos.put(arr[i],i);
        }



        for(int i=0; i<pieces.length;i++){
            int piece[]=pieces[i];
            boolean valid= validate(piece, pos,truth );
            if(!valid)
                return valid;

        }
        for(boolean x:truth){
            if(!x){
                return x;
            }
        }
        return true;

    }

    boolean validate(int []piece, Map<Integer, Integer> pos, boolean truth[]){
        if(pos.get(piece[0])==null)
            return false;
        int firstPos=pos.get(piece[0]);

        for(int i=0;i<piece.length;i++){
            int x=piece[i];
            if(pos.get(x)==null || pos.get(x)!=firstPos)
                return false;
            firstPos++;
            truth[pos.get(x)]=true;
        }
        return true;
    }
}
