package backtracking;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        System.out.println(l.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {

        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            Integer current = Integer.valueOf(String.valueOf(digits.charAt(i)));
            List<Character> vals = map.get(current);
            if (res.isEmpty()) {
                for (int j = 0; j < vals.size(); j++) {
                    char currChar = vals.get(j);
                    res.add(String.valueOf(currChar));
                }
            } else {
                List<String> old = new ArrayList<>(res);
                res.clear();
                for (int j = 0; j < vals.size(); j++) {
                    char currChar = vals.get(j);

                    List<String> cp = new ArrayList<>();
                    for (int k = 0; k < old.size(); k++) {
                        String e = old.get(k);
                        e = e + String.valueOf(currChar);
                        cp.add(e);
                    }
                    res.addAll(cp);

                }
            }

        }

        return res;
    }
}

