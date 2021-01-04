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
    public int totalFruit(int[] tree) {
            int st=0;
            int max=Integer.MIN_VALUE;
            HashMap<Integer,Integer>freq= new HashMap<>();
            int sum=0;
            for (int end = 0; end < tree.length ; end++) {
                int fruitType= tree[end];
                freq.put(fruitType, freq.getOrDefault(fruitType, 0)+1);
                while(freq.size()>2){
                    int fruitAtSt= tree[st++];
                    freq.put(fruitAtSt, freq.get(fruitAtSt)-1);
                    if(freq.get(fruitAtSt)==0)
                        freq.remove(fruitAtSt);

                }
                max= Integer.max(end-st+1, max);
            }
            return max;


    }
}
