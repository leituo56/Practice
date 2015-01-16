package org.leituo.Other;

import java.util.Stack;

/**
 * Created by leituo56 on 1/15/15.
 */
public class SortStack {
    public void sort(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        int num = stack.pop();
        sort(stack);
        insert(stack, num);
    }
    private void insert(Stack<Integer> stack, int num){
        if(stack.isEmpty() || num <= stack.peek()) {
            stack.push(num);
        }else{
            int tmp = stack.pop();
            insert(stack, num);
            stack.push(tmp);
        }
    }

    public static void main(String[] args) {
        SortStack test = new SortStack();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i<100; i++){
            stack.push((int)(Math.random() * 100));
        }
        test.sort(stack);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + ", ");
        }
    }
}
