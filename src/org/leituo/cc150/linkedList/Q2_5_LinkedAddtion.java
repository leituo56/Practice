//  2.5
//  You have two numbers represented by a linked list, where each node contains a single digit.
//  The digits are stored in reverse order,such that the 1's digit is at the head of the list.
//  Write a function that adds the two numbers and returns the sum as a linked list.
//        FOLLOW UP
//        Suppose the digits are stored in forward order. Repeat the above problem.
package org.leituo.cc150.linkedList;

/**
 * Created by leituo56 on 10/29/14.
 */
public class Q2_5_LinkedAddtion {
    //StoreReverse
    public Node LinkedListBackAdd(Node first, Node second){
        int sum = first.data + second.data;
        int carry = sum / 10;
        int remain = sum % 10;

        Node result = new Node(remain);
        first = first.next;
        second = second.next;

        while (first!=null || second!=null){
            if (first==null){
                result.append(second.data + carry);
                carry = 0;
                second = second.next;
            }else if (second==null){
                result.append(first.data + carry);
                carry = 0;
                first = first.next;
            }else { //both not null
                sum = first.data + second.data;
                remain = sum % 10;
                result.append(remain + carry);
                carry = sum / 10;
                first = first.next;
                second = second.next;
            }
        }
        if(carry>0)
            result.append(carry);
        return result;
    }
    public Node reverseLinkedList(Node n){
        Node result = new Node(n.data);
        n = n.next;
        while (n!=null){
            Node next = n.next;
            n.next = result;
            result = n;
            n = next;
        }
        return result;
    }
    public static void main(String[] args) {
        Q2_5_LinkedAddtion test = new Q2_5_LinkedAddtion();
        //617 + 295
        Node f1 = new Node(7).append(1).append(6);
        Node f2 = new Node(5).append(9).append(2);
        test.LinkedListBackAdd(f1, f2).print();

        test.reverseLinkedList(f1).print();
        test.reverseLinkedList(f2).print();
    }
}
