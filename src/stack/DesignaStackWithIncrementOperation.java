package stack;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=1381,
title = "Design a Stack With Increment Operation",
level = Level.MEDIUM,
url = "https://leetcode.com/problems/design-a-stack-with-increment-operation/")
public class DesignaStackWithIncrementOperation {
}
class CustomStack {
    int maxSize;
    int arr[];
    int curr;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        this.arr= new int[maxSize];
        curr=0;
    }

    public void push(int x) {
        if(curr<maxSize){
            arr[curr]=x;
            curr++;
        }

    }

    public int pop() {
        if(curr>0){
            int elem= arr[curr-1];
            arr[curr-1]=0;
            curr--;
            return elem;

        }else{
            return -1;
        }

    }

    public void increment(int k, int val) {
        if(k>maxSize)
            k=maxSize;

        for(int i=0;i<k;i++){
            arr[i]+=val;

        }

    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */