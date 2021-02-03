package arrays;

public class TwoSumIIInputarrayissorted
{
    public int[] twoSum(int[] nums, int target) {
        int n[]=new int[2];
        int st=0;
        int end=nums.length-1;
        while(st<end){
            int currentSum=nums[st]+nums[end];
            // System.out.println(st+" "+end+" sum="+currentSum);
            if(currentSum==target){

                n[0]=st+1;
                n[1]=end+1;
                break;
            }
            else if(currentSum<target){
                st++;
            }else {
                end--;

            }
        }


        return n;
    }
}
