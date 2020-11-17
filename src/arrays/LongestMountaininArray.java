package arrays;

public class LongestMountaininArray {
    public int longestMountain(int[] A) {
        //List<Integer> peaks= new ArrayList<>();
        boolean isIncreasing=false;
        boolean isDecreasing=false;
        int size=A.length;
        int max=0;
        boolean peakFound=false;
        for(int i=1;i<A.length-1;i++){
            int  count=1;
            int j=i;
            while(j<size && A[j]>A[j-1]){
                //  System.out.println("inc "+A[i]+" count="+count);

                isIncreasing=true;
                count++;
                j++;


            }
            while(j>0 && i!=j && j<size && A[j-1]>A[j] && isIncreasing){
                //  System.out.println("Dec "+A[i]+" count="+count);
                isDecreasing=true;
                count++;
                j++;
            }
            if(isDecreasing && isDecreasing){
                // System.out.println("Find Max");
                max= Integer.max(max, count);
                peakFound=true;
                isIncreasing=false;
                isDecreasing=false;

                j--;
            }
            i=j;

        }

        return !peakFound?0: max;
    }
}
