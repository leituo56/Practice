//Given a set of distinct integers, S, return all possible subsets.
//
//        Note:
//        Elements in a subset must be in non-descending order.
//        The solution set must not contain duplicate subsets.
//        For example,
//        If S = [1,2,3], a solution is:
//
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]
package org.leituo.leetcode.bitManipulation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 12/20/14.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int times = (int) Math.pow(2, S.length);
        Arrays.sort(S);
        for (int i=0; i < times; i++){
            List<Integer> item = new LinkedList<Integer>();
            for(int j = 0; j < S.length; j++){
                if((i >> j & 1) == 1)
                    item.add(S[j]);
            }
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        int[] data = {1,2,3};
        List<List<Integer>> result = test.subsets(data);
        for (List<Integer> list:result){
            for (int item:list){
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
