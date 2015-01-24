//  2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
//  Copy the next data and point to next.next
package org.leituo.cc150.DataStructure.linkedList;

/**
 * Created by leituo56 on 10/28/14.
 */
public class Q2_3_DeleteANodeWithoutHead {
    public void deleteNode(Node n){
        n.data = n.next.data;
        n.next = n.next.next;
    }
    public static void main(String[] args) {
        Q2_3_DeleteANodeWithoutHead test = new Q2_3_DeleteANodeWithoutHead();

        Node head = new Node(1);
        head.append(2).append(3).append(4).append(5);
        test.deleteNode(head.next.next);
        head.print();
    }
}
class Node{
    public Node next = null;
    public int data;
    public Node(int i){
        this.data = i;
    }
    public Node append(int i){
        Node tail = new Node(i);
        Node n = this;
        while (n.next!=null){
            n = n.next;
        }
        n.next = tail;
        return this;
    }
    public void print(){
        Node n = this;
        while (n.next!=null){
            System.out.print(n.data);
            System.out.print(" --> ");
            n = n.next;
        }
        System.out.print(n.data);
        System.out.print(" --> ");
        System.out.println("null");
    }
}
