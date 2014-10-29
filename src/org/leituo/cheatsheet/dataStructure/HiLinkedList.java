package org.leituo.cheatsheet.dataStructure;

/**
 * Created by leituo56 on 10/28/14.
 */
public class HiLinkedList {
    public Node deleteNode(Node head, int n){
        Node temp = head;
        if(temp.data == n)// When remove head
            return head.next;
        while (temp.next!=null){
            if (temp.next.data == n){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        //print
        HiLinkedList test = new HiLinkedList();
        Node list1 = new Node(1);
        list1.append(2).append(3).append(4).append(5);
        list1.print();
        //delete
        test.deleteNode(list1, 3);
        list1.print();

    }
}
class Node{
    Node next = null;
    int data;
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
