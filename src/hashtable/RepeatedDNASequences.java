package hashtable;

import java.util.*;
// 187. Repeated DNA Sequences
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> sol= new ArrayList<>();
        if(s.length() <10) return sol;
        Map<String,Integer> dna= new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            dna.compute(s.substring(i,(i+10)) ,(k, v) -> (v == null) ? 1 : v+1 ) ;
        }
        Set<String> keys= dna.keySet();
        for(String key: keys){
            if(dna.get(key)>1)
                sol.add(key);
        }
        return sol;
    }
}
