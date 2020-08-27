package string;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {
    public static void main(String[] args) {
       //
    }
    //using arraylist
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res= new ArrayList();
        for(int i=0;i<nums.length;i++){
            int freq=nums[i];
            int num=nums[i+1];
            for(int j=0;j<freq;j++){
                res.add(num);
            }
            i++;

        }
        int[] arr = new int[res.size()];
        for (int i=0;i<res.size();i++) {
            arr[i] = res.get(i);

        }
        return arr;
    }
    //without helper classed
    public int[] decompressRLElist2(int[] nums) {
        int resLength = 0;
        for (int i = 0; i < nums.length; i = i+2) {
            resLength += nums[i];
        }

        int[] res = new int[resLength];

        int currentPos = 0;
        for (int i = 1; i < nums.length; i=i+2) {
            for (int j = 0; j < nums[i-1]; j++) {
                res[currentPos+j] = nums[i];
            }
            currentPos += nums[i-1];
        }
        return res;
    }

}
