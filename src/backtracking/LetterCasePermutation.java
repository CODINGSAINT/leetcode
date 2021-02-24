package backtracking;

import java.util.*;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {

        List<String> list = new ArrayList<>();
        list.add(S);
        for (int i = 0; i < S.toCharArray().length; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                String str = list.get(j);
                char[] strChars = str.toCharArray();
                char charAti = strChars[i];
                if (!Character.isDigit(charAti)) {
                    if (Character.isUpperCase(charAti)) {
                        strChars[i] = Character.toLowerCase(charAti);
                    } else if (Character.isLowerCase(charAti)) {
                        strChars[i] = Character.toUpperCase(charAti);
                    }
                    list.add(String.valueOf(strChars));
                }

            }
        }
        return list;

    }
}
