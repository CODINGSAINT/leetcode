package backtracking;
import java.util.*;
public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Integer,List<Character>> map= new HashMap<>();
        map.put(2, List.of('a','b','c'));
        map.put(3, List.of('d','e','f'));
        map.put(4, List.of('g','h','i'));
        map.put(5, List.of('j','k','l'));
        map.put(6, List.of('m','n','o'));
        map.put(7, List.of('p','q','r','s'));
        map.put(1, List.of('t','u','v'));
        map.put(1, List.of('w','x','y','z'));
        List<String> res=new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            Integer current=Integer.valueOf(String.valueOf(digits.charAt(i)));
            List<Character> vals=map.get(current);
            for(int j=0;j<vals.size();j++){
                char currChar=vals.get(j);
                if(res.isEmpty()){
                    res.add(String.valueOf(currChar));
                }else{
                    List<String>cp= new ArrayList<>();
                    for(int k=0;k<res.size();k++){
                        String e=res.get(k);
                        e=e+String.valueOf(currChar);
                        cp.add(e);
                    }
                    res.clear();
                    res.addAll(cp);
                }
            }
        }

        return res;
    }
}
