package string;
//https://leetcode.com/problems/detect-capital/
public class DetectCapital {
    public static void main(String[] args) {

    }

    public boolean detectCapitalUse(String s) {
        char wordsChar[] = s.toCharArray();
        int startRange = 65;
        int endRange = 90;
        if (wordsChar.length >= 2) {
            boolean allLowerCase = false;
            if (wordsChar[0] >= 97 || wordsChar[1] >= 97) {
                allLowerCase = true;
            }

            if (allLowerCase) {
                startRange = 97;
                endRange = 122;
            }
            for (int i = 1; i < wordsChar.length; i++) {
                if (!(wordsChar[i] >= startRange && wordsChar[i] <= endRange)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
