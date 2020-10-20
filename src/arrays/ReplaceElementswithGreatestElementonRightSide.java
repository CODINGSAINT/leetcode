package arrays;
//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
//1299. Replace Elements with Greatest Element on Right Side

public class ReplaceElementswithGreatestElementonRightSide {
    public int[] replaceElements(int[] arr) {
        int maxSeen=arr[arr.length-1];

        for(int i=arr.length-2;i>=0;i--){
            int temp= arr[i];
            arr[i]=maxSeen;
            if(temp>maxSeen)
                maxSeen=temp;

        }
        arr[ arr.length-1]=-1;
        return arr;
    }
}
