package arrays;
//1450 https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
public class NumberofStudentsDoingHomeworkataGivenTime {
    public static void main(String[] args) {

    }
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count=0;

        for(int i=0;i<startTime.length;i++){
            if(startTime[i] <=queryTime && endTime[i]>=queryTime)
                count++;
        }
        return count;
    }
}
