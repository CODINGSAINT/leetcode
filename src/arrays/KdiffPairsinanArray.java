package arrays;
import java.util.*;
//https://leetcode.com/problems/k-diff-pairs-in-an-array/
//532. K-diff Pairs in an Array
public class KdiffPairsinanArray {
    public static void main(String[] args) {
        int nums[]={1,3,1,5,4};
        KdiffPairsinanArray k= new KdiffPairsinanArray();
        System.out.println(k.findPairs(nums,0));
    }

    public int findPairs(int[] nums, int k) { 
        int pair=0;

        Set<Integer> vals= new HashSet<>();

        for(int i=0;i<nums.length;i++){
            boolean added=vals.add(nums[i]);
            if(k==0 && !added)
                pair++;
        }
        if(k==0 && vals.size()==1 && nums.length>1) return 1;
        if(k==0) return pair;
        //System.out.println(vals);
        Iterator<Integer> it = vals.iterator();
        Set<Integer> checked=new HashSet<>();
        while(it.hasNext()){
            int num=it.next();
            if(vals.contains(num+k) && !checked.contains(num+k) ){
                pair++;
                checked.add(num);
                checked.add(num+k);

            }if(vals.contains(num-k) && !checked.contains(num-k)  ){
                pair++;
                checked.add(num);
                checked.add(num-k);
            }
        }




        return pair;
    }
}
