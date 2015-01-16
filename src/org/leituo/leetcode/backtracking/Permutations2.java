//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].
package org.leituo.leetcode.backtracking;

import java.util.*;

/**
 * Created by leituo56 on 1/15/15.
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(num == null || num.length == 0)
            return result;
        Arrays.sort(num);
        LinkedList<Integer> list = new LinkedList<Integer>();
        boolean[] flags = new boolean[num.length];
        permute(result, num, list, flags, 0);
        return result;
    }
    private void permute(List<List<Integer>> result, int[] num, List<Integer> list, boolean[] flags, int deep){
        if(deep >= num.length){
            result.add(new LinkedList<Integer>(list));
            return;
        }
        for(int i = 0; i<num.length; i++){
            if(flags[i])
                continue;
            list.add(num[i]);
            flags[i] = true;
            permute(result, num, list, flags, deep + 1);
            flags[i] = false;
            list.remove(list.size() - 1);
            while(i < num.length - 1 && num[i] == num[i+1])
                i++;
        }
    }

    public static void main(String[] args) {
        Permutations2 test = new Permutations2();
        int[] data = {2,2,1,1};
        List<List<Integer>> result = test.permuteUnique(data);
        for (List<Integer> list:result){
            for (int elem:list){
                System.out.print(elem + ", ");
            }
            System.out.println();
        }
    }
}
