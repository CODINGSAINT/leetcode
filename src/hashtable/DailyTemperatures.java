package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] temp) {
        Map<Integer,Integer> tempMap= new HashMap<Integer,Integer>();
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<temp.length;i++){
            int currentTemp=temp[i];
            while(!st.isEmpty()&& temp[st.peek()]< temp[i] ){
                tempMap.put(st.peek(),i-st.pop());
            }
            st.push(i);
        }
        int res[]=new int[temp.length];

        for(int i=0;i<temp.length;i++){
            res[i]= tempMap.getOrDefault(i,0);
        }
        return res;
    }
}
