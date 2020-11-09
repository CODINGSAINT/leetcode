package string;

import utils.LeetCode;
import utils.Level;

@LeetCode(
      no = 1614,
      title = "https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/",
      url = "Maximum Nesting Depth of the Parentheses",
      level =  Level.EASY)
public class MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        if(s.length()==0) return 0;
        char []chars=s.toCharArray();
        int minDepth=0;
        int maxDepth=0;
        for(char c:chars){
            if(c=='('){

                minDepth++;
            }else if  (c==')'){
                maxDepth=Integer.max(maxDepth,minDepth);
                minDepth--;
            }
        }
        return maxDepth;
    }

}
