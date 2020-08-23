package arrays;

import java.util.List;
//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithTheGreatestNumberofCandies {

    public static void main(String[] args) {

    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int highest=0;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>highest){
                highest=candies[i];
            }

        }
        List<Boolean> res= new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            res.add(candies[i]+extraCandies>=highest);

        }
        return res;
    }
}
