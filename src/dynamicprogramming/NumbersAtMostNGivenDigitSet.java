package dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

public class NumbersAtMostNGivenDigitSet {
    public static void main(String[] args) {
        NumbersAtMostNGivenDigitSet n= new NumbersAtMostNGivenDigitSet();
        //System.out.println(n.atMostNGivenDigitSet(new String[]{"1","3","5","7"
        //}, 3345));
        /*System.out.println(n.atMostNGivenDigitSet(new String[]{"1","3","5","7"
        }, 767)); */
        System.out.println(n.atMostNGivenDigitSet(new String[]{"1","7"
        }, 231));

    }
    public int atMostNGivenDigitSet(String[] digits, int k) {

        int n= digits.length;
        int[] c=new int [n];
        for(int i=0;i< n;i++){
            c[i]= Integer.parseInt(digits[i]);
            //      System.out.print(" "+c[i]);
        }
        if(k<10){
            int cnt= 0;
            for(int x:c){
                if(x<=k)
                    cnt++;
            }
            return cnt;
        }

        Arrays.sort(c);
        String kStr=k+"";
        Integer maxDigits[]= new Integer [kStr.length()];
        int m= maxDigits.length;
        for(int i=0;i< m;i++){
            maxDigits[i]= Character.getNumericValue(kStr.charAt(i));
            //  System.out.print(" "+maxDigits[i]);
        }
        // Arrays.sort(maxDigits , Collections.reverseOrder());

        int results[]= new int[m+1];
        int total[]= new int [m+1];
        //dummy init for 0th
        results[0]= 1;
        for(int i=1;i<m+1;i++){
            if(i<m){
                results[i]=results[i-1]*n;
                total[i]= total[i-1]+results[i];
            }

            if(i==m){
                //int count=count(results,maxDigits, c, m);
                int count =count(digits,results, kStr,m,0 );
                total[i]= count+total[i-1];
            }

            // System.out.print(" "+total[i]);

        }

        return total[m];
    }


    private int count(String[] digits,int power[],String n,int len,int index){
        //We have reached till last index, a number can be formed such that <= N,
        if(index==len) return 1;
        int res=0;
        for(String val : digits){
            if(val.charAt(0)>n.charAt(index)) break;
            else if (val.charAt(0)<n.charAt(index)) res+=power[len-index-1];
            else if (val.charAt(0)==n.charAt(index)) res+=count(digits,power,n,len,index+1);
        }
        return res;
    }

    int count(int result[], Integer maxDigits[], int digits[],int max ){
        int count =0;

        int currentMax=maxDigits[0];
        int maxIndex=0;
        int resultIndex=0;
        int m= maxDigits.length;

        //if the current of the digits (in Asc order ) is less than number position
        // there are total result[m-1] results possible
        for(int i=0;i<digits.length;i++){

            if(maxIndex<maxDigits.length-1  &&  digits[i]<maxDigits[maxIndex]){
                count+=result[max-1];
            }else{
                if(maxIndex<maxDigits.length-1  && digits[i]==maxDigits[maxIndex]){
                    maxIndex++;
                    i=-1;
                    max--;
                }

                if( i==digits.length-1  ){
                    //int j=0;
                    for(int j=0;j<digits.length;j++){
                        if(digits[j]<=maxDigits[maxIndex] && digits[i]<maxDigits[maxIndex]){

                            count++;
                        }else{
                            break;
                        }

                    }
                }
            }
        }

        return count;
    }
}