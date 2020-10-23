package stack;

import java.util.Stack;

//456. 132 Pattern
public class _132Pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st= new Stack<>();
        int secondNumber= Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            int firstNumber = nums[i] ;
            if(secondNumber>firstNumber) return true;
            while(!st.isEmpty() && nums[i] > st.peek() )
                secondNumber= st.pop();
            st.push(firstNumber);


        }
        return false;
    }
}
