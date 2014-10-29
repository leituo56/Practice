//  2.7 Implement a function to check if a linked list is a palindrome,
//  0,1,2,3,2,1,0
package org.leituo.cc150.linkedList;

/**
 * Created by leituo56 on 10/29/14.
 */
public class Q2_7_Palindrome {
    public boolean isPalindrome(Node n){
        Node n2 = this.reverseLinkedList(n);
        while (n != null){
            if(n.data != n2.data)
                return false;
            n = n.next;
            n2 = n2.next;
        }
        return true;
    }
    public Node reverseLinkedList(Node n){
        Node result = new Node(n.data);
        n = n.next;
        while (n!=null){
            Node temp = new Node(n.data);
            temp.next = result;
            result = temp;
            n = n.next;
        }
        return result;
    }
    public static void main(String[] args) {
        Q2_7_Palindrome test = new Q2_7_Palindrome();
        Node t1 = new Node(0).append(1).append(2).append(3).append(2).append(1).append(0);
        System.out.println(test.isPalindrome(t1));
        System.out.println(test.isPalindrome(t1.append(0)));
    }
}
