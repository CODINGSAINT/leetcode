package backtracking;

import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@LeetCode(
        no=47,
        title = "Permutations II",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/permutations-ii/"
)
public class PermutationsII {
    Set<List<Integer>> vals= new HashSet<>();
    int visited[]=null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visited= new int[nums.length];
        permute(nums,new ArrayList<Integer>());

        return new ArrayList<>(vals);

    }
    private void permute(int[] nums, ArrayList<Integer> list) {
        if(list.size()==nums.length) {
            vals.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(visited[i]==0) {
                list.add(nums[i]);
                visited[i]=1;
                permute(nums, list);
                list.remove(list.size()-1);
                visited[i]=0;
            }

        }



    }
}

