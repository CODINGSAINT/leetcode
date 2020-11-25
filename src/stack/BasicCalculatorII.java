package stack;

import utils.LeetCode;
import utils.Level;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
@LeetCode(no = 227,
        title = "Basic Calculator II",
        url = "https://leetcode.com/problems/basic-calculator-ii/",
        level = Level.MEDIUM
)
//TODO Use Stack and Solve
public class BasicCalculatorII {
    public int calculate(String s) {
        char chars[]=s.toCharArray();

        // Stack<Integer> vals= new Stack<>();


        int curr=0;
        int prev=0;
        int res=0;
        char op='+';
        for (int i = 0; i < s.length (); i++) {
            char c = s.charAt (i);

            if(c>=48 && c<=57){
                curr=curr*10+c-'0';
                // System.out.println(curr);
            }

            if (i == s.length () - 1 || c != ' ' && !(c >= 48 && c <= 57)) {
                if(op=='+'){
                    res+=prev;
                    prev=curr;
                }else if(op=='-'){
                    res += prev;
                    prev = -curr;
                }else if(op=='*'){
                    prev*=curr;
                }else if(op=='/'){
                    prev/=curr;
                }
                // System.out.println("res="+res+" prev="+prev+" curr="+curr);
                op=c;
                curr=0;
            }

        }
        res+=prev;
        return res;
    }
}
