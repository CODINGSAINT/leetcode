package arrays;
// 1486. XOR Operation in an Array
public class XOROperationinanArray {
    public int xorOperation(int n, int start) {
        int arr[]= new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=start+2*i;
            sum=sum^arr[i];
        }
        return sum;
    }
}