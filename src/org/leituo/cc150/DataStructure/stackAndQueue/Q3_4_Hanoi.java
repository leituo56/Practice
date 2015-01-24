//3.4 In the classic problem of the Towers of Hanoi,
//you have 3 towers and N disks of different sizes which can slide onto any tower.
//        The puzzle starts with disks sorted in ascending order of size from top to bottom
//        (i.e., each disk sits on top of an even larger one). You have the following constraints:
//        (T) Only one disk can be moved at a time.
//        (2) A disk is slid off the top of one tower onto the next rod.
//        (3) A disk can only be placed on top of a larger disk.
package org.leituo.cc150.DataStructure.stackAndQueue;

import java.util.Stack;

/**
 * Created by leituo56 on 10/29/14.
 */
public class Q3_4_Hanoi {
    public Q3_4_Hanoi() {
        Tower t1 = new Tower(3, 1);
        Tower t2 = new Tower(0, 2);
        Tower t3 = new Tower(0, 3);
        t1.move(3, t1, t2, t3);
    }

    public static void main(String[] args) {
        Q3_4_Hanoi test = new Q3_4_Hanoi();
    }
}
class Tower{
    Stack<Integer> disks;
    int index;
    Tower(int numOfDisks, int index) {
        this.index = index;
        this.disks = new Stack<Integer>();
        for (int i = numOfDisks;i > 0; i--){
            disks.push(i);
        }
    }
    public void move(int num, Tower src, Tower buffer, Tower dest){
        if (num == 1){
            src.send(dest);
        }else {
            move(num - 1, src, dest, buffer);
            move(1, src, buffer, dest);
            move(num - 1, buffer, src, dest);
        }
    }
    public void send(Tower t){
        if (this.isEmpty()){
            System.out.println("Tower[" +index + "] is empty!");
            System.exit(1);
        }
        int val = disks.pop();
        System.out.println("Tower[" + index + "] is sending " + val + " to Tower["+ t.index +"]!!!");
        t.accept(val);
    }
    public void accept(int i){
        if (!this.isEmpty() && i>disks.peek()){
            System.out.println("Things goes wrong!!!");
            System.exit(1);
        }
        disks.push(i);
    }
    public boolean isEmpty(){
        return this.disks.isEmpty();
    }
}
