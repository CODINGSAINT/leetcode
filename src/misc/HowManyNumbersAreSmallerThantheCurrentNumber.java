package misc;
//1365 How Many Numbers Are Smaller Than the Current Number

public class HowManyNumbersAreSmallerThantheCurrentNumber {
    public static void main(String[] args) {

    }
    //using brute force as upper range of program is not too big
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int res[]= new int[nums.length];

        for (int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j])
                    count++;
            }
            res[i]=count;
        }
        return res;
    }
}
