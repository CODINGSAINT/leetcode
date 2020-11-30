package graph;

import utils.LeetCode;
import utils.Level;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 1306.
@LeetCode(no = 1306,
        title = "Jump Game III",
        url = "https://leetcode.com/problems/jump-game-iii/",
        level = Level.MEDIUM)
public class JumpGameIII {
    public static void main(String[] args) {
        JumpGameIII j = new JumpGameIII();
        System.out.println(j.canReach(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0}, 3));
    }
    // Keep a stack for index and visited array

    /**
     * Add first index to stack ,
     * while stack is not empty
     * pop index
     * mark it visited
     * and verify the result if 0 return true
     * <p>
     * i + arr[i] < arr.length && [i + arr[i]] has not been added to visited add to stack
     * <p>
     * i - arr[i]>= 0 && [i - arr[i]] has not been added to visited add to stack
     *
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        if (arr.length == 0) return false;
        boolean[] visited = new boolean[arr.length];
        Stack<Integer> st = new Stack();
        st.add(start);
        while (!st.isEmpty()) {
            int i = st.pop();

            if (arr[i] == 0) {
                return true;
            }
            //visit i
            visited[i] = true;
            //Check if i + arr[i] and i - arr[i] can be visited or not
            if ((i + arr[i]) < arr.length && !visited[i + arr[i]]) {
                st.add(i + arr[i]);
            }
            if ((i - arr[i]) > -1 && !visited[i - arr[i]]) {
                st.add(i - arr[i]);
            }
        }
        return false;
    }

    //Without Stack

    /**
     * For All Values there are 2 possible paths either it can move forward or backward, except 0th and last index.
     * For 0th it can only go forward and for last index we can move backward.
     * <p>
     * Keep seen - array of boolean for tracking indexes that we have already verified , so that we don't in go in loop forever
     * if arr[index]= 0 return true
     * if index =0 return the check with -> start+arr[start]
     * if index =n , where n is length of array return the check with -> start-arr[start]
     * if it index >=0 && index<n
     * check the results for start+arr[start] || start-arr[start]
     *
     * @param arr
     * @param start
     * @return
     */
    public boolean canReachW(int[] arr, int start) {
        int n=arr.length;
        if(start>n)
            return false;


        boolean []seen=new boolean[arr.length];
        return verify(arr,seen, start,n );

    }
    boolean verify(int[] arr, boolean []seen, int start,int n){

        if(seen[start]==false){
            seen[start]=true;
            if(arr[start]==0) return true;

            if(start==0){
                // System.out.println("At Start "+0);
                if(start+arr[start] < n)
                    return verify(arr, seen, start+arr[start], n);
                else
                    return false;
            }
            else if(start==n-1){
                // System.out.println("At last "+start);
                if(start-arr[start] >=0 )
                    return verify(arr, seen, start-arr[start], n);
                else
                    return false;
            }else{
                if((start-arr[start] >0) && (start+arr[start] < n) ){

                    //System.out.println("In Between "+start);
                    return verify(arr, seen, start-arr[start], n) ||
                            verify(arr, seen, start+arr[start], n);

                }else if(start-arr[start] >=0 ){
                    return verify(arr, seen, start-arr[start], n);
                }else if(start+arr[start] < n){

                    return verify(arr, seen, start+arr[start], n);

                }

            }





        }
        return false;
    }
    public boolean canReachS(int[] arr, int start) {
        if(arr.length ==0) return false;
        boolean []visited= new boolean[arr.length];
        Stack<Integer> st= new Stack();
        st.add(start);
        while(!st.isEmpty()){
            int i= st.pop();
            //visit i
            if (arr[i]==0){
                return true;
            }
            visited[i]=true;
            //Check if i + arr[i] and i - arr[i] can be visited or not
            //System.out.println(( i+arr[i])+"visited[arr [( i+arr[i] )]]"+visited [( i+arr[i] )]);

            //System.out.println(( i-arr[i])+"visited[arr [( i+arr[i] )]]"+visited [( i-arr[i] )]);
            if((i+arr[i])<arr.length && ! visited [i+arr[i] ]){
                //  System.out.println("adding + "+ (i+arr[i])+ "+ arr[i+arr[i]]+ "+ + arr[i+arr[i]]);
                st.add(i+arr[i]);
            }
            if((i-arr[i])>-1 && !visited[ i-arr[i]] ){
                //  System.out.println("adding - "+ (i-arr[i])+ "+ arr[i+arr[i]]+ "+ + arr[i-arr[i]]);

                st.add(i-arr[i]);
            }
        }
        return false;
    }
}
