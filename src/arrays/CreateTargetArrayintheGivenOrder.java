package arrays;
// 1389 Create Target Array in the Given Order
//https://leetcode.com/problems/create-target-array-in-the-given-order/
public class CreateTargetArrayintheGivenOrder {
    public static void main(String[] args) {

    }
    public int[] createTargetArray(int[] nums, int[] index) {

        int res[]= new int[nums.length];
        for(int i=0;i<index.length;i++){
            int idx= index[i];
            for( int j=index.length-1;j>idx;j--){
                res[j]=res[j-1];
            }
            res[index[i]]=nums[i];

        }
        return res;
    }
}
