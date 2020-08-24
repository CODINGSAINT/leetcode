package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/number-of-good-pairs/
public class NumberofGoodPairs {
    public static void main(String[] args) {

    }
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> goodPairs= new HashMap<>();
        for(int i:nums){
            goodPairs.put(i,goodPairs.getOrDefault(i,0)+1);
        }
        int totalCount=0;
        Set<Integer> keys=goodPairs.keySet();
        for(int k:keys){
            int val= goodPairs.get(k) ;
            if(val>1){
                totalCount+= val * (val-1)/2;
            }
        }
        return totalCount;
    }
}
