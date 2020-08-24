package stack;

import java.util.Stack;

public class MinStack {
    private int minElem ;
    private Stack<Integer> st;

    /** initialize your data structure here. */
    public MinStack() {
        minElem = Integer.MAX_VALUE;
        st= new Stack();

    }

    public void push(int x) {


        if(x <= minElem){
            st.push(minElem);
            minElem = x;
        }

        st.push(x);


    }

    public void pop() {
        if(st.pop()==minElem){
            minElem=st.pop();
        }

    }

    public int top() {
        return st.peek();

    }

    public int getMin() {
        return minElem;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */