package string;

import utils.LeetCode;
import utils.Level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@LeetCode(no=819,title = "Most Common Word",url = "https://leetcode.com/problems/most-common-word/",level = Level.EASY)
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet=new HashSet<>();
        for(String b:banned){
        bannedSet.add(b);
    }
    paragraph = paragraph.toLowerCase();
    paragraph = paragraph.replaceAll("\\W"," ");
    // System.out.println(paragraph.replaceAll(","," ").replaceAll("[^a-zA-Z\\s]",""));
    String paragraphArray[]=paragraph.split("\\s+");
    Map<String,Integer> map=new HashMap<>();
    String current="";
        for(String s: paragraphArray){
        current=s.toLowerCase().trim();
        if(! bannedSet.contains(current)){
            //   System.out.println(current);
            map.compute(current,(k,v)->(v==null)?1:v+1);
        }
    }
    Set<String>keys= map.keySet();
    String mostFreq="";
    int mostFreqCount=0;

        for(String s:keys){

        if(map.get(s)>mostFreqCount){
            mostFreqCount=map.get(s);
            mostFreq=s;
        }
    }
        return mostFreq;
}
}
