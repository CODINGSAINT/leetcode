package multithreading;

import utils.LeetCode;
import utils.Level;

@LeetCode(
no=1114, title="Print in Order", level= Level.MEDIUM, url="https://leetcode.com/problems/print-in-order/")
public class PrintinOrder {


}
class Foo {
    private boolean first;
    private boolean second;

    public Foo() {
        first=false;
        second=false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first=true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(!first){
            wait();
        }
        printSecond.run();
        second=true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(!second){
            wait();
        }
        printThird.run();
    }
}
