package arrays;

import utils.LeetCode;
import utils.Level;

import java.util.Arrays;
@LeetCode(no=1701,title = "Average Waiting Time",level = Level.MEDIUM,url = "https://leetcode.com/problems/average-waiting-time/"
        )
public class AverageWaitingTime {
    public double averageWaitingTime(int[][] c) {
        int n = c.length;
    int startTime=0;
    int lastDishFinishTime=0;
    // System.out.println(n);
    int array[]=new int[n];

    int totalTime=0;
        for(int i=0; i<c.length; i++){
        int [] current= c[i];
        int arrivalTime= current[0];
        int timeTaken= current[1];

        startTime=Integer.max(lastDishFinishTime, arrivalTime);
        int timeTakenToPrepare= (startTime+ timeTaken )- arrivalTime;
        //System.out.println(i+ " Time Taken "+timeTakenToPrepare);
        //totalTime+=timeTakenToPrepare;
        array[i]=timeTakenToPrepare;
        lastDishFinishTime=startTime+timeTaken;



    }
    //System.out.println();
    double result= Arrays.stream(array).average().orElse(0);

        return  result;


}
}
