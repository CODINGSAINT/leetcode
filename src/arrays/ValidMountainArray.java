package arrays;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if(arr.length<=2) return false;
        boolean increasing=true;
        if(arr[0]>arr[1]) return false;
        for(int i=1;i<arr.length;i++){
            if( arr[i]==arr[i-1]){
                return false;
            }else if (increasing && arr[i]<arr[i-1]){
                increasing=false;
            }else if(!increasing  && arr[i]>arr[i-1] ){
                return false;
            }
        }
        return  !increasing && true;

    }
}
