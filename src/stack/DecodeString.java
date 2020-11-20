package stack;

import utils.LeetCode;
import utils.Level;

import java.util.Stack;


@LeetCode(no = 394,
        title = "Decode String",
        level = Level.MEDIUM,
        url = "https://leetcode.com/problems/decode-string/")
public class DecodeString {


    public String decodeString(String s) {

        Stack<Integer> nSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        String str = new String();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int no = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    no = no * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                nSt.push(no);
                continue;
            }
            if (c == '[') {
                strSt.push(sb.toString());
                //str=sb.toString();
                sb = new StringBuilder();
            } else if (c == ']') {
                int repeats = nSt.pop();
                StringBuilder temp = new StringBuilder(strSt.pop());
                while (repeats-- != 0) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
