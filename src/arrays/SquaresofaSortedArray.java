package arrays;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        int[] arr = new int[A.length];
        int i=A.length-1;
        int j=0;
        int k=A.length-1;
        while(k>-1)
        {
            if(Math.abs(A[j])>A[i])
            {
                arr[k--]=A[j]*A[j];
                j++;
            }
            else
            {
                arr[k--]=A[i]*A[i];
                i--;
            }
        }

        return arr;
    }
}
