package tree;

class Solution {
    public void sortColors(int[] nums) {
        int redIndex=0;
        int blueIndex=nums.length-1;
        int current=0;

        while(current<=blueIndex) {

            if(nums[current]==2){
                swap(nums,current,blueIndex);
                blueIndex--;
            }else if(nums[current]==0){
                swap(nums,current,redIndex);
                redIndex++;
                current++;
            }else{
                current++;
            }

        }


    }
    public void swap(int arr[], int index1, int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}