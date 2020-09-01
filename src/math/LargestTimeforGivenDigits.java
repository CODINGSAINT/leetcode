package math;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeforGivenDigits {

    public static void main(String[] args) {
        LargestTimeforGivenDigits l= new LargestTimeforGivenDigits();
        System.out.println(l.largestTimeFromDigits (new int[] {2,0,6,6}));
    }
    public String largestTimeFromDigits(int[] a) {
        String s=largestPossibleWithMaxHrs(a,2);
        if(s.equals("")){
            s=largestPossibleWithMaxHrs(a,1);
        }
        return s;

    }
    public String largestPossibleWithMaxHrs(int []a ,int maxHrs){

        StringBuffer sb= new StringBuffer();
        List<Integer> usedIndex= new ArrayList<>();
        int firstPos = largestPossible(maxHrs,0,a,usedIndex);
        if(firstPos==-1){
            return "";
        }
        sb.append(a[firstPos]);
        usedIndex.add(firstPos);
        int secondPos=-1;

        if(a[firstPos]==2){
            secondPos= largestPossible(3,0,a,usedIndex);
        }else{
            secondPos= largestPossible(9,0,a,usedIndex);

        }
        if(secondPos==-1){
            return "";
        }
        usedIndex.add(secondPos);
        sb.append(a[secondPos]);
        int thirdPos= largestPossible(5,0,a,usedIndex);
        if(thirdPos==-1){
            return "";
        }
        sb.append(":");
        usedIndex.add(thirdPos);
        sb.append(a[thirdPos]);

        int forthdPos= largestPossible(9,0,a,usedIndex);
        if(forthdPos==-1){
            return "";
        }
        sb.append(a[forthdPos]);

        return sb.toString();



    }



    public int largestPossible (int maxPossible, int minPossible, int []a , List<Integer> usedIndex){
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<a.length;i++){
            if(!usedIndex.contains(i)){
                if(a[i]>=minPossible && a[i]<=maxPossible && a[i]>max){
                    max=a[i];
                    index=i;
                }
            }

        }

        return index;
    }
}
