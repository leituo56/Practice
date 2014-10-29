//  2.2 Implement an algorithm to find the kth to last element of a singly linked list.
package org.leituo.cc150.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by leituo56 on 10/28/14.
 */
public class Q2_2_KthLastElem {
    //O(n) time.
    public int kthBiggestElem(LinkedList<Integer> list, int k){
        ListIterator<Integer> it = list.listIterator();
        ListIterator<Integer> runner = list.listIterator();
        for (int i=0; i<k; i++){
            if (it.hasNext())
                it.next();
            else
                return runner.next();
        }
        while (it.hasNext()){
            it.next();
            runner.next();
        }
        return runner.next();
    }
    public static void main(String[] args) {
        Q2_2_KthLastElem test = new Q2_2_KthLastElem();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(test.kthBiggestElem(list, 3));
        System.out.println(test.kthBiggestElem(list, 1));
    }
}
