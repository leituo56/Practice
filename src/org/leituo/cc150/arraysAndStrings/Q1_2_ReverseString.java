//  1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null- terminated string.
//  This should implemented in C/C++
//  String Buffer
package org.leituo.cc150.arraysAndStrings;

/**
 * Created by leituo56 on 10/25/14.
 */
public class Q1_2_ReverseString {
    //O(n) time, O(n) space
    public String reverseString(String str){
        int len = str.length();
        StringBuffer dest = new StringBuffer(len);
        for (int i= len -1; i>=0; i--){
            dest.append(str.charAt(i));
        }
        return dest.toString();
    }

    //O(n) time, O(1) space
    public int[] reverseArray(int[] array){
        int len = array.length;
        for (int i = 0; i < len*1.0/2; i++) {
            int temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
        return array;
    }
    public static void main(String[] args) {
        Q1_2_ReverseString test = new Q1_2_ReverseString();
        String result = test.reverseString("Hello Tuo!");
        System.out.println(result);

        int[] array = {1,2,3,4,5};
        test.reverseArray(array);
        for (int anArray : array) {
            System.out.print(anArray);
        }
    }
}
