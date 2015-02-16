//Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
//
//Try to solve it in linear time/space.
//
//Return 0 if the array contains less than 2 elements.
//
//You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
package org.leituo.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leituo56 on 1/15/15.
 */
public class MaximumGap {
    public int maximumGap(int[] num) {
        if(num.length < 2)
            return 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int item:num){
            list.add(item);
        }
        List<Integer> one = new ArrayList<Integer>();
        List<Integer> zero = new ArrayList<Integer>();
        for(int i = 0; i<32; i++){
            int mask = 1 << i;
            for(int item:list){
                if((item & mask) != 0){
                    one.add(item);
                }else{
                    zero.add(item);
                }
            }
            list.clear();
            list.addAll(zero);
            list.addAll(one);
            one.clear();
            zero.clear();
        }
        int max = 0;
        for(int i = 1; i < list.size(); i++){
            max = Math.max(max, list.get(i) - list.get(i-1));
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumGap test = new MaximumGap();
        int[] data = {1, 10000};
        System.out.println(test.maximumGap(data));
    }
}
