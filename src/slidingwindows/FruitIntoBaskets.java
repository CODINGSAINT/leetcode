package slidingwindows;
import utils.LeetCode;
import utils.Level;

import java.util.*;

@LeetCode(no =904,
        level = Level.MEDIUM,
        title = "Fruit Into Baskets",
        url="https://leetcode.com/problems/fruit-into-baskets/")
public class FruitIntoBaskets {
    public static void main(String[] args) {
        FruitIntoBaskets f= new FruitIntoBaskets();
        System.out.println(f.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));

    }
    public int totalFruit(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int i=0;
        int j=0;
        int len= arr.length;
        int max=Integer.MIN_VALUE;
        while(i<len){
            Integer c= arr[i];
            map.compute(c, (k,v) -> v==null?1:v+1);
            while(map.size()>2){
                int val= map.get(arr[j]);
                map.put(arr[j], --val);
                if(val<=0)
                    map.remove((arr[j]));
                j++;
            }
            max= Integer.max(max, i+1-j);
            i++;
        }
        return max;
    }
}
