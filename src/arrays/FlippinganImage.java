package arrays;
//https://leetcode.com/problems/flipping-an-image/
public class FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i=0;i<A.length;i++){
            int current[] =A[i];
            int low=0;
            int high = current.length-1;
            while(high>=low){
                int temp=current[high];
                current[high]=(current[low]==0?1:0) ;
                current[low]= (temp==0?1:0);
                high--;
                low++;
            }
        }
        return A;

    }
}
