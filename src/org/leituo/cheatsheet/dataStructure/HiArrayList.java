//  Implementation: double size when full
//  O(1) access
//  list.add(elem)  list.add(index, elem)
//  list.get(index)
package org.leituo.cheatsheet.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leituo56 on 10/24/14.
 */
public class HiArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.addAll(Arrays.asList(1,2,3,4,5));
        list.add(2,100);

        System.out.println(list);
        System.out.println(list.get(2));
    }
}
