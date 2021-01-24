import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        // int encoded
        //  System.out.println(Math.abs(Math.abs((6^4))));

        /*System.out.println(Math.abs(2-(Math.abs(~(1^2)))));
        System.out.println(Math.abs(3-(Math.abs(~(2^3)))));*/
        // System.out.println(~(2^3));
        //decode(new int[]{1,2,3},1);
        //decode(new int[]{6,2,7,3},4);

        Solution s = new Solution();
        //  System.out.println(s.tupleSameProduct(new int[]{2,3,4,6}));


        //System.out.println(s.largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}}));

       // System.out.println( s.minCharacters("aba","caa"));
     //  System.out.println(s.minCharacters("dabadd","cda"));

        /*     System.out.println(s.minCharacters("aba","caa"));
*/
      System.out.println(s.minCharacters("dabadd","cda"));




    }
    public  int minCharacters(String a, String b) {
        return Integer.min(transformAllChar(a,b) ,
                Integer.min(
                        minChanges(a,b)
                        ,minChanges(b,a)  ));

    }
    public int minChanges(String a, String b){

        //check for elements from b-z calculating the number of changes required so that all elements are less than b-z in a and greater that b-z in b
        int minChanges=a.length()+b.length();
        for(char current='b';current<='z' ;current++){
            //check no of changes required to make the String Strictly less than current
            int count=0;

            for(int i=0;i<a.length();i++){
                if(a.charAt(i)<current){
                    count++;
                }
            }
            for(int i=0;i<b.length();i++){
                if(b.charAt(i)>=current){
                    count++;
                }
            }
            minChanges=Integer.min(minChanges,count);
        }
        System.out.println("minChanges ="+minChanges);

        return minChanges;
    }



    int transformAllChar(String a,String b){
        int minChanges=a.length()+b.length();
        for(char current='a';current<='z' ;current++){
            //check no of changes required to make the String Strictly less than current
            int count=0;

            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!=current){
                    count++;
                }
            }
            for(int i=0;i<b.length();i++){
                if(b.charAt(i)!=current){
                    count++;
                }
            }
            minChanges=Integer.min(minChanges,count);
        }
        System.out.println("Transfomation ="+minChanges);
        return minChanges;
    }
}
