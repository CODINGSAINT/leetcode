package string;
//|804|[Unique Morse Code Words](https://leetcode.com/problems/unique-morse-code-words/)|Easy | [UniqueMorseCodeWords](https://github.com/CODINGSAINT/leetcode/blob/master/src/string/UniqueMorseCodeWords.java)|
public class UniqueMorseCodeWords {
    public void reverseString(char[] s) {
        int j= s.length-1;
        for(int i=0; i<j; i++){
            char temp= s[i];
            s[i] =s[j];
            s[j]=temp;
            j--;
        }

    }
}
