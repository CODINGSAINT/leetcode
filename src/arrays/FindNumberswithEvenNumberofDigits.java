package arrays;

public class FindNumberswithEvenNumberofDigits {
    public int findNumbers(int[] nums) {
        int even=0;
        int count =1;
        for(int i: nums){
            while(i>=10){
                i=i/10;
                count++;
            }
            if(count%2==0){
                even++;
            }
            count=1;


        }
        return even;

    }
}
