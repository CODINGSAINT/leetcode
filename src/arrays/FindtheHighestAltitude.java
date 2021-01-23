package arrays;
/*1732. Find the Highest Altitude*/
public class FindtheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int highest=0;
        int sum=0;
        for (int i = 0; i < gain.length; i++) {
            sum+=gain[i];
            highest=Integer.max(sum,highest);
        }
        return highest;
    }
}
