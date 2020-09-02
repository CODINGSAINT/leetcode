package arrays;

public class ContainsDuplicateIII {
    public static void main(String[] args) {
        ContainsDuplicateIII c= new ContainsDuplicateIII();
      /*  System.out.println(
                c.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3,0)
        );



        System.out.println(
                c.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1,2)
        );

        System.out.println(
                c.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2,3)
        );*/

        System.out.println(
                c.containsNearbyAlmostDuplicate(new int[]{0}, 0,0)
        );
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for(int i =0;i<nums.length-1;i++){

           int pos = i+k;
            if(pos>nums.length-1){
                pos=nums.length-1;
            }

            for(int j=pos;j>i;j--){
                long val1 = (long) nums[j];
                long val2 = (long) nums[i];
                long result = val1-val2;
               if(result<0){
                    result = result*-1;
                }
                if(result<=t){
                    return true;
                }
            }
        }

        return false;
    }

}
