//  3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
// Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
// Implement a data structure SetOfStacks that mimics this. SetOf- Stacks should be composed of several stacks
// and should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and
// SetOfStacks. pop () should behave identically to a single stack (that is, pop () should return the same values
// as it would if there were just a single stack).
//  FOLLOW UP
//  Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
//  fix approach
//  shift approach
package org.leituo.cc150.DataStructure.stackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by leituo56 on 10/29/14.
 */
public class Q3_3_SetOfStack {
    public Q3_3_SetOfStack() {
        SetOfStack s = new SetOfStack();
        for (int i = 0; i < 100 ; i++) {
            s.push(i);
        }
        for (int i = 0; i < 100 ; i++) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        Q3_3_SetOfStack test = new Q3_3_SetOfStack();
    }
}
class SetOfStack{
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    int capacity = 10;
    public void push(int val){
        Stack<Integer> last = this.getLastStack();
        if (last != null && last.size() < capacity){
            last.push(val);
        }else{
            Stack<Integer> s = new Stack<Integer>();
            s.push(val);
            stacks.add(s);
        }
    }
    public int pop(){
        Stack<Integer> last = this.getLastStack();
        int v = last.pop();
        if (last.size() == 0)
            this.stacks.remove(this.stacks.size() - 1);
        return v;
    }
    private Stack<Integer> getLastStack(){
        if (stacks.isEmpty())
            return null;
        else
            return stacks.get(stacks.size() - 1);
    }
}
