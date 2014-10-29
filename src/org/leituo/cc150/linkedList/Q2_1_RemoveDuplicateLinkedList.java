//  2.1 Write code to remove duplicates from an unsorted linked list. FOLLOW UP
//  How would you solve this problem if a temporary buffer is not allowed?
package org.leituo.cc150.linkedList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by leituo56 on 10/28/14.
 */
public class Q2_1_RemoveDuplicateLinkedList {
    //O(n) time, more space
    public void removeDuplicated(LinkedList<Character> list){
        ListIterator<Character> head = list.listIterator();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (head.hasNext()){
            Character val = head.next();
            if(map.containsKey(val)){
                head.remove();
            }else {
                map.put(val, 1);
            }
        }
    }
    public static void main(String[] args) {
        Q2_1_RemoveDuplicateLinkedList test = new Q2_1_RemoveDuplicateLinkedList();
        LinkedList<Character> list = new LinkedList<Character>();
        char[] c_set = "FOLLOW UP".toCharArray();
        for (char c:c_set){
            list.add(c);
        }
        System.out.println(list);
        test.removeDuplicated(list);
        System.out.println(list);
    }
}
