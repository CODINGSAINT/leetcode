import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
     /*   System.out.println(s.mergeAlternately("abcd","pq"));
        System.out.println(s.mergeAlternately("ab","pqrs"));
        System.out.println(s.mergeAlternately("abc","pqr"));
*/
        System.out.println(s.minOperations("001011"));
     //System.out.println(s.maximumScore(new int[]{-5,-3,-3,-2,7,1} , new int[]{-10,-5,3,4,6}));
     // System.out.println(s.maximumScore(new int[]{-5,-3} , new int[]{-10}));



    }

    public int[] minOperations(String b) {
        char boxes[]=b.toCharArray();
        int n=boxes.length;
        int forward[]= new int[n];
        int backward[]=new int[n];
        int count[]= new int[n];
        //Let us calculate forward
        int currentSteps=0;
         currentSteps=boxes[0]=='0'?0:1;
        for (int i = 1; i < n; i++) {
            forward[i]=forward[i-1]+currentSteps;
            currentSteps+=boxes[i]-'0';
        }
        currentSteps=boxes[n-1]=='0'?0:1;
        for (int i = n-2; i >=0; i--) {
            backward[i]=backward[i+1]+currentSteps;
            currentSteps+=boxes[i]-'0';
        }
        for (int i = 0; i < n; i++) {
            count[i]=forward[i]+backward[i];
        }

        return count;
    }


    public int maximumScore(int[] nums, int[] multipliers) {
        int max=0;
        int n=nums.length;
        int m=multipliers.length;
        int dp[]=new int[m];

        return max;

    }
    int calculateMax(int []nums, int multipliers[],int i, int start, int end ){
        int left=nums[i]*multipliers[start]+calculateMax(nums,multipliers,i+1,start+1,end);
        int right=nums[i]*multipliers[end]+calculateMax(nums,multipliers,i+1,start,end-1);
        return Integer.max(left,right);
    }
    public String mergeAlternately(String word1, String word2) {
        int len =Integer.max(word1.length() , word2.length());
        StringBuffer sb= new StringBuffer();
        for (int i = 0; i < len; i++) {
            if(i>word1.length()-1){
                sb.append(word2.substring(i));
                break;
            }if(i>word2.length()-1){
                sb.append(word1.substring(i));
                break;
            }
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));

        }
        return sb.toString();
        }
}