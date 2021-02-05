package arrays;
import java.util.*;
public class MaximumNumberofBallsinaBox {
    public int countBalls(int lowLimit, int highLimit) {

        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer>freq= new HashMap<>();

        for (int i = lowLimit; i <=highLimit; i++) {
            int sum=0;
            int current=i;
            while(current>0){
                sum+=current%10;
                current=current/10;
            }
            freq.put(sum, freq.getOrDefault(sum,0)+1);
            max=Integer.max(max,freq.get(sum));
        }
        return max;
    }
}
