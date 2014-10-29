//  2.4 Write code to partition a linked list around a value x,
//  such that all nodes less than x come before alt nodes greater than or equal to x
package org.leituo.cc150.linkedList;

/**
 * Created by leituo56 on 10/28/14.
 */
public class Q2_4_Partition {
    public Node partition(Node head, int pivot){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pivotNode = null;
        Node next;
        while (head != null){
            next = head.next;
            if (head.data<pivot){
                if (beforeStart == null){
                    beforeStart = head;
                    beforeEnd = head;
                }else {
                    head.next = beforeStart;
                    beforeStart = head;
                }

            }else if (head.data>pivot){
                if (afterStart==null){
                    afterStart = head;
                    afterEnd = head;
                }else {
                    head.next = afterStart;
                    afterStart = head;
                }
            }else {
                pivotNode = head;
            }
            head = next;
        }
        beforeEnd.next = pivotNode;
        pivotNode.next = afterStart;
        afterEnd.next = null;
        return beforeStart;
    }
    public static void main(String[] args) {
        Q2_4_Partition test = new Q2_4_Partition();
        Node node = new Node(5);
        node.append(3).append(7).append(1).append(9).append(11).append(13);
        node.print();
        Node result = test.partition(node, 5);
        result.print();
    }
}
