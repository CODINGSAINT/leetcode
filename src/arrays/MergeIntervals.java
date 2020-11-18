package arrays;
import utils.LeetCode;
import utils.Level;

import java.util.*;

@LeetCode(no=56,
        url = "https://leetcode.com/problems/merge-intervals/",
        title = "Merge Intervals",
        level = Level.MEDIUM
)

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> merged= new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]) );
        int n= intervals.length;
        int st=intervals[0][0];
        int end=intervals[0][1];
        for(int i=0;i<n;i++){
            if (intervals[i][1] < end) {
                continue;
            }

            if (intervals[i][0] > end) {
                List<Integer> inner= new ArrayList<>(2);
                inner.add(st);
                inner.add(end);
                merged.add(inner);
                st = intervals[i][0];
            }
            end = intervals[i][1];


        }

        List<Integer> in= new ArrayList<>(2);
        // i=j;
        in.add(st);
        in.add(end);
        merged.add(in);

        //st=intervals[i][0];





        int [][] result= new int[merged.size()][2];
        int i=0;
        for(List<Integer> inner: merged){
            result[i][0]=inner.get(0);
            result[i][1]=inner.get(1);
            i++;
        }

        return result;
    }
}
