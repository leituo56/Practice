//  1.3 Given two strings, write a method to decide if one is a permutation of the other.
package org.leituo.cc150.DataStructure.arraysAndStrings;

/**
 * Created by leituo56 on 10/26/14.
 */
public class Q1_3_IsPermutationString {
    //For ASCII
    //O(n) time
    public boolean isPermutationString(String str1, String str2){
        if (str1.length() != str2.length())
            return false;
        int[] charSet = new int[256];
        for (int i=0; i<str1.length(); i++){
            int char1 = str1.charAt(i);
            int char2 = str2.charAt(i);
            charSet[char1] += 1;
            charSet[char2] -= 1;
        }
        for (int item:charSet){
            if (item!=0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Q1_3_IsPermutationString test = new Q1_3_IsPermutationString();
        boolean result1 = test.isPermutationString("123542", "123453");
        System.out.println(result1);
    }
}
