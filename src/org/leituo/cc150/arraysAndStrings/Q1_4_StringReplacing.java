//  1.4 Write a method to replace all spaces in a string with '%20'.
//  You may assume that the string has sufficient space at the end of the string to hold the additional characters,
//  and that you are given the "true" length of the string.
//  (Note: if implementing in Java, please usea character array so that you can perform this operation inplace.)
//  Key, reverse copy
package org.leituo.cc150.arraysAndStrings;

/**
 * Created by leituo56 on 10/26/14.
 */
public class Q1_4_StringReplacing {
    public void urlEncode(char[] content, int length){
        int newLength = length;
        for (int i = 0; i < length; i++) {
            if (content[i] == ' '){
                newLength += 2;
            }
        }
        content[newLength] = '\0';
        for (int i = length - 1; i >=0; i--) {
            if (content[i]==' '){
                content[--newLength] = '0';
                content[--newLength] = '2';
                content[--newLength] = '%';
            }else {
                content[--newLength] = content[i];
            }
        }
    }
    public static void main(String[] args) {
        Q1_4_StringReplacing test = new Q1_4_StringReplacing();
        char[] content = "what the matter?           ".toCharArray();
        test.urlEncode(content, 15);
        System.out.println(new String(content));
    }
}
