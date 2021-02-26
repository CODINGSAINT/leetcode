package string;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 14,
        level = Level.MEDIUM ,
        title = "Longest Common Prefix",
        url="https://leetcode.com/problems/longest-common-prefix/")
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String commonPrefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            if(commonPrefix.equals("")) {
                return "";
            }
            commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }

    String getCommonPrefix(String value1, String value2) {
        if(value2.length() == 0) {
            return "";
        }
        int i = 0;
        for(i=0; i<Math.min(value1.length(), value2.length()); i++) {
            if(value1.charAt(i)!=value2.charAt(i)) {
                return value1.substring(0, i);
            }
        }
        return value1.substring(0, i);
    }
}
