package string;
//|344|[Reverse String](https://leetcode.com/problems/reverse-string/)|Easy | [ReverseString](https://github.com/CODINGSAINT/leetcode/blob/master/src/string/ReverseString.java)|
public class ReverseString {
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
