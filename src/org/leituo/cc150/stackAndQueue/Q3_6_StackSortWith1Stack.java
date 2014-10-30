//  3.6 Write a program to sort a stack in ascending order (with biggest items on top).
// You may use at most one additional stack to hold items, but you may not copy the elements
// into any other data structure (such as an array). The stack supports the following operations:
// push, pop, peek, and isEmpty.
package org.leituo.cc150.stackAndQueue;

import java.util.Stack;

/**
 * Created by leituo56 on 10/30/14.
 */
public class Q3_6_StackSortWith1Stack {
    public void sort(Stack<Integer> src){
        Stack<Integer> buffer = new Stack<Integer>();
        int temp;
        while (!src.isEmpty()){
            temp = src.pop();//raise
            // buffer move to src until temp < buffer top
            while (!buffer.isEmpty() && temp > buffer.peek()){
                move(buffer, src);
            }
            // put raise to buffer
            buffer.push(temp);
            // src move to buffer until src.peek > buffer.peek
//            while (!src.isEmpty() &&src.peek() < buffer.peek()){
//                move(src, buffer);
//            }
        }
        while (!buffer.isEmpty()){// Move back
            move(buffer, src);
        }
    }
    public void move(Stack<Integer> from, Stack<Integer> to){
        to.push(from.pop());
    }
    public static void main(String[] args) {
        Q3_6_StackSortWith1Stack test = new Q3_6_StackSortWith1Stack();
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 100; i++) {
            s.push((int)Math.round(Math.random()*100));
        }
        test.sort(s);
        System.out.println("[" + s.size() + "]");
        while (!s.isEmpty())
            System.out.println(s.pop());

    }
}
