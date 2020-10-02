package arrays;
//39. Combination Sum
import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  combinations= new ArrayList<> ();
        var current= new ArrayList<Integer>();
        Arrays.sort(candidates);
        getCombinations(candidates,combinations,current,0,target);
        return combinations;

    }

    void getCombinations(int[] candidates,List<List<Integer>> combinations, ArrayList<Integer>current, int index,int target){
        if(target<=0) {
            if(target==0){
                combinations.add(new ArrayList<Integer>(current));
            }
            return;
        }
        if(index<candidates.length){
            var value=candidates[index];
            current.add(value);
            getCombinations(candidates,combinations, current, index,target-value);
            if(current.size()>0)
                current.remove(current.size()-1);
            getCombinations(candidates,combinations, current, index+1,target);

        }
    }
}
