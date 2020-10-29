package arrays;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 849,
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/maximize-distance-to-closest-person/",
        title = "Maximize Distance to Closest Person")
public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int []leftZero= new int[seats.length];
        int lastZero=1;
        int maxIndex=0;
        int onesCount=0;
        int firstOneIndex=0;
        int lastOneIndex=0;
        int maxVal=Integer.MIN_VALUE;
        for (int i=0;i<seats.length;i++){
            if(seats[i]==1){
                onesCount++;

                leftZero[i]=Integer.MIN_VALUE;
                lastZero=1;

                if(onesCount==1){
                    firstOneIndex=i;
                    lastOneIndex=i;
                }else{
                    lastOneIndex=i;
                }
            }else{

                leftZero[i]=lastZero;
                lastZero++;
            }
            if(maxVal<leftZero[i]){
                maxVal=leftZero[i];
                maxIndex=i;
            }
        }

        if( onesCount==1 && (seats[0]==1 ||seats[seats.length-1]==1))
            return maxVal;

        if((firstOneIndex!=0 && leftZero[firstOneIndex-1]==maxVal) ||leftZero[seats.length-1]==maxVal)
            return maxVal;
        int leftMostIndex=maxIndex-maxVal;
        int goTill=maxVal/2;
        int rightDiff=(maxIndex)-(leftMostIndex+goTill);

        int max= Math.max(goTill,rightDiff);
        if(firstOneIndex!=0 ){
            max=Math.max(max,leftZero[firstOneIndex-1]);
        }
        max=Math.max(max,leftZero[seats.length-1]);
        return  max;

    }
}
