package stack;
import java.util.*;
//402. Remove K Digits M
//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        Stack<Integer> st= new Stack<>();
        st.add(Integer.parseInt(num.charAt(0)+""));
        int count=0;
        for(int i=1;i<num.length();i++){
            Integer n=Integer.parseInt(num.charAt(i)+"");
            while(!st.isEmpty() && st.peek()>n && k>0 ){
                st.pop();
                k--;
            }
            if(st.isEmpty() && n==0)
                continue;
            st.push(n);

        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuffer sb=new StringBuffer();
        while(! st.isEmpty()){

            sb.append(st.pop());
        }
        // System.out.println(sb.toString());
        String result=sb.reverse().toString();
        // result=result.
        return result.length()==0?"0":result;
    }
}
