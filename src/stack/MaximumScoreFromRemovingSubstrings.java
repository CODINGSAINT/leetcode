package stack;
import java.util.*;
import utils.LeetCode;
import utils.Level;

@LeetCode(no = 1717,
        level = Level.MEDIUM ,
        title = "Maximum Score From Removing Substrings",
        url="https://leetcode.com/problems/maximum-score-from-removing-substrings/")
public class MaximumScoreFromRemovingSubstrings {
    String s="";
    public int maximumGain(String s, int x, int y) {
        this.s=s;
        StringBuilder result = new StringBuilder();
        this.s = s;
        if (x > y)
            return calculate('a', 'b') * x + calculate('b', 'a') * y;
        return calculate('b', 'a') * y + calculate('a', 'b') * x;




    }
    public int calculate( char a, char b){
        int total=0;
        int val=0;
        Stack<Character> stack= new Stack<>();
        for (char current:s.toCharArray()) {
            if(stack.size()>0  && stack.peek()==a && current==b ){
                val++;
                stack.pop();
            }else{
                stack.push(current);

            }
        }
        StringBuffer sb= new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        s=sb.reverse().toString();
        return  val;
    }

}
