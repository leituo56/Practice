//  2.6 Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.

package org.leituo.cc150.DataStructure.linkedList;

/**
 * Created by leituo56 on 10/29/14.
 */
public class Q2_6_CircularHead {
    //O(n) time, O(1) space
    public Node CircularHead(Node n){
        Node fastRunner = n;
        Node slowRunner = n;
        while (fastRunner.next!=null && fastRunner.next.next!=null){
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
            if (fastRunner == slowRunner)
                break;
        }
        System.out.println(fastRunner.data);

        fastRunner = n;
        while (fastRunner != slowRunner){
            fastRunner = fastRunner.next;
            slowRunner = slowRunner.next;
        }
        return fastRunner;
    }
    public static void main(String[] args) {
        Q2_6_CircularHead test = new Q2_6_CircularHead();
        Node n = new Node(0);
        Node temp = n;
        for (int i = 1; i < 11; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        temp.next = n.next.next.next;    //3
        System.out.println(test.CircularHead(n).data);
    }
}
