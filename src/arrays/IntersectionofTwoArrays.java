package arrays;
import java.util.*;
//https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len=nums1.length;
        int len2=nums2.length;
        List<Integer>result=find(nums1, nums2);
        return result.stream().mapToInt(Integer::intValue).toArray();

    }
    List<Integer> find(int nums1[],int nums2[]){

        int st1=0;
        int st2=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer>result= new HashSet<>();
        while(st1< nums1.length && st2<nums2.length){
            if(nums1[st1] < nums2[st2]){
                st1++;
            }else if(nums1[st1] > nums2[st2]){
                st2++;
            }else{
                result.add(nums1[st1]);
                st1++;
                st2++;
            }
        }
        return new ArrayList<>(result);
    }
}