package hashtable;

import java.util.*;

public class UniqueNumberofOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int val = map.getOrDefault(i, 0);
            map.put(i, ++val);
        }
        Set<Integer> keys = map.keySet();
        Set<Integer> values = new HashSet();
        System.out.println(map);
        for (int key : keys) {
            if (!values.add(map.get(key))) {
                return false;
            }
        }
        return true;
    }
}