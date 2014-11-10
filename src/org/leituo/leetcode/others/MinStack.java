//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

//push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.
package org.leituo.leetcode.others;

import java.util.Stack;

/**
 * Created by leituo56 on 11/9/14.
 */
class MinStack {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        if(x<=getMin())
            min.push(x);
        data.push(x);
    }

    public void pop() {
        int value = data.pop();
        if(value==getMin())
            min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        if(min.isEmpty())
            return Integer.MAX_VALUE;
        else
            return min.peek();
    }
}
