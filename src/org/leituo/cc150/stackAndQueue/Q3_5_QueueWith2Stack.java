//  3.5 Implement a MyQueue class which implements a queue using two stacks.
package org.leituo.cc150.stackAndQueue;

import java.util.Stack;

/**
 * Created by leituo56 on 10/30/14.
 */
public class Q3_5_QueueWith2Stack {
    public Q3_5_QueueWith2Stack() {
        MyQueue<Integer> q = new MyQueue<Integer>();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        q.enQueue(4);
        q.enQueue(5);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }

    public static void main(String[] args) {
        Q3_5_QueueWith2Stack test = new Q3_5_QueueWith2Stack();
    }
}
class MyQueue<T>{
    Stack<T> forIn = new Stack<T>();
    Stack<T> forOut = new Stack<T>();
    public void enQueue(T item){
        if (forIn.isEmpty()){
            rotate(forOut, forIn);
        }
        forIn.push(item);
    }
    public T deQueue(){
        if (forOut.isEmpty()){
            rotate(forIn, forOut);
        }
        if (forOut.isEmpty()){
            return null;
        }
        return forOut.pop();
    }
    private void rotate(Stack<T> from, Stack<T> to){
        while (!from.isEmpty()){
            to.push(from.pop());
        }
    }
}
