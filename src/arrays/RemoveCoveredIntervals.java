package arrays;
//1288. Remove Covered Intervals
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        // [[3,10],[4,10],[5,11]]
        int removed=0;

        for(int i=0;i<intervals.length;i++){
            int []current=intervals[i];
            if(current!=null ){

                for(int j=0;j<intervals.length;j++){
                    int []compare=intervals[j];
                    if(i!=j && compare != null){
                        if(compare[0] <= current[0] && current[1] <= compare[1] ){
                            intervals[i]=null;
                            removed++;
                            break;
                        }
                    }
                }
            }
        }
        /*int c=0;

        for(int[] interval:intervals){
            if(interval!=null) c++;
        }
        System.out.println(c+"-"+(intervals.length-removed));*/
        return (intervals.length-removed);
    }
}
