package arrays;
// 1588. Sum of All Odd Length Subarrays
public class SumofAllOddLengthSubarrays {
    /**
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int w=1;
        int len=arr.length;
        int sum=0;
        // let us find the max possible window. if the length is even we can have max possible window on len-1 else lrg
        int maxWindowSize= len%2==0? len-1:len;
        //till we create all possible windows to slide
        while(w<=maxWindowSize){
            for(int i=0;i<=len-w;i++){
                // window will be from current i to i+window size (w) , add them for solution
                for(int j=i; j<(i+w); j++ ){
                    sum+=arr[j];
                }

            }
            w=w+2;
        }
        return sum;
    }
}
