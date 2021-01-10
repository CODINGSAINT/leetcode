public class Solution {
    public static void main(String[] args) {
       // int encoded
       System.out.println(Math.abs(Math.abs((6^4))));

        /*System.out.println(Math.abs(2-(Math.abs(~(1^2)))));
        System.out.println(Math.abs(3-(Math.abs(~(2^3)))));*/
       // System.out.println(~(2^3));
        //decode(new int[]{1,2,3},1);
        //decode(new int[]{6,2,7,3},4);



    }

    public  static int[] decode(int[] encoded, int first) {
        int arr[] = new int [encoded.length+1];
        arr[0]= first;
        for(int i=1;i<encoded.length+1;i++){


            arr[i]=Math.abs(arr[i-1]^encoded[i-1] );
            System.out.println( arr[i]);

        }
        return arr;
    }


}
