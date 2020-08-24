package hashtable;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelAndStones {
    public static void main(String[] args) {

    }
    public int numJewelsInStones(String J, String S) {
        Map<Character,Character> stoneTypes=new HashMap<>();
        char jewelChars[]=J.toCharArray();
        for(int i=0;i<jewelChars.length;i++){
            stoneTypes.put(jewelChars[i],jewelChars[i]);
        }
        char allStones[]= S.toCharArray();
        int total=0;
        Character currentStone= null;
        for(int i=0;i<allStones.length;i++){
            currentStone= stoneTypes.get(allStones[i]);
            if(currentStone!=null){
                total++;
            }
        }
        return total++;
    }
}
