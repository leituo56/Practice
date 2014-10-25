//  1.1 Implement an algorithm to determine if a string has all unique characters.
//  What if you cannot use additional data structures?
//  ?extend: what about an array?
package org.leituo.cc150.arraysAndStrings;

import java.util.HashMap;

/**
 * Created by leituo56 on 10/24/14.
 */
public class Q1_1_UniqChar {
    //O(n) time
    public boolean uniqChar(String str){
        if(str.length()>256)
            return false;
        boolean[] set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(set[val])
                return false;
            set[val] = true;
        }
        return true;
    }
    //O(n) time, lot of space
    public boolean uniqArray(int[] list){
        HashMap<Integer, Boolean> set = new HashMap<Integer, Boolean>();
        for (int i = 0; i < list.length; i++) {
            int val = list[i];
            if(set.containsKey(val))//O(1)
                return false;
            set.put(val, true);
        }
        return true;
    }
    public static void main(String[] args) {
        Q1_1_UniqChar test = new Q1_1_UniqChar();
        boolean result = test.uniqChar("What the fuck!");
        boolean result1 = test.uniqChar("AaBbCc");
        System.out.println(result);
        System.out.println(result1);

        int[] list1 = {1,2,3,4,5,6};
        int[] list2 = {1,3,2,5,1,6};
        boolean result3 = test.uniqArray(list1);
        boolean result4 = test.uniqArray(list2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
