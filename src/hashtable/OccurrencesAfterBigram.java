package hashtable;
import java.util.*;
//1078 https://leetcode.com/problems/occurrences-after-bigram/
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res=new ArrayList<>();
        String[] textArray= text.split(" ");
        for(int i=1;i<textArray.length-1;i++){
            if(textArray[i-1].equals(first) &&
                    textArray[i].equals(second)){
                res.add(textArray[i+1]);
            }
        }
        String resStr[]= new String[res.size()];
        for(int i=0;i<res.size();i++){
            resStr[i]=res.get(i) ;
        }
        return resStr;
    }
}
