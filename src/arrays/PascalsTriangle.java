package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.List;

@LeetCode(no=118,
        title = "Pascal's Triangle",
        level = Level.EASY,
        url = "https://leetcode.com/problems/pascals-triangle/"
)
public class PascalsTriangle {
    public static void main(String[] args) {

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        if(numRows==0) return list;
        int [][]nums=new int[numRows][numRows];
        nums[0][0]=1;
        List<Integer> levels= new ArrayList<>();
        levels.add(1);
        list.add(new ArrayList(levels));
        levels.clear();
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    nums[i][j]=1;
                }
                else{
                    nums[i][j]+=nums[i-1][j-1]+nums[i-1][j];
                }
                levels.add(nums[i][j]);
            }
            list.add(new ArrayList(levels));
            levels.clear();
        }

        return list;

    }
}
