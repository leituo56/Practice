//  3.2 How would you design a stack which, in addition to push and pop,
//  also has a function s2 which returns the minimum element?
//  Push, pop and s2 should all operate in 0(1) time
package org.leituo.cc150.DataStructure.stackAndQueue;

import java.util.Stack;

/**
 * Created by leituo56 on 10/29/14.
 */
public class Q3_2_MinStack {
    public Q3_2_MinStack() {
        MinStack m = new MinStack();
        m.push(5);
        m.push(6);
        m.push(3);
        m.push(7);
        m.pop();
        m.pop();
    }

    public static void main(String[] args) {
        Q3_2_MinStack test = new Q3_2_MinStack();
    }
}
class MinStack extends Stack<Integer>{
    Stack<Integer> s2;
    MinStack() {
        this.s2 = new Stack<Integer>();
    }
    public void push(int item) {
        if (item < min())
            s2.push(item);
        super.push(item);
        System.out.println(min());
    }


    public synchronized Integer pop() {
        int value = super.pop();
        if (value == min())
            s2.pop();
        System.out.println(min());
        return value;
    }
    public int min(){
        if (this.isEmpty()){
            return Integer.MAX_VALUE;
        }else {
            return s2.peek();
        }
    }
}