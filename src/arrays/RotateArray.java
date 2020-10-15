package arrays;
//189. Rotate Array
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int res[]= nums.clone();
        int mod = k % nums.length;
        int n= nums.length;

        for(int i=0;i<nums.length;i++){
            res[(i+mod)%n] =nums[i] ;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }


    }
}
