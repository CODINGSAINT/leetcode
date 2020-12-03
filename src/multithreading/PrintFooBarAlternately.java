package multithreading;

import utils.LeetCode;
import utils.Level;

@LeetCode(no = 1115,
        title = "Print FooBar Alternately",
        url = "https://leetcode.com/problems/print-foobar-alternately/",
        level = Level.MEDIUM)
public class PrintFooBarAlternately {
}
class FooBar {
    private int n;
    boolean toggle;

    public FooBar(int n) {
        this.n = n;
        toggle=true;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            if(!toggle){
                wait();
            }
            printFoo.run();
            toggle=!toggle;
            notifyAll();

        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            if(toggle){
                wait();
            }
            printBar.run();
            toggle=!toggle;
            notifyAll();

        }
    }
}