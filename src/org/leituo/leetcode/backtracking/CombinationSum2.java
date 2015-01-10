//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 10,1,2,7,6,1,5 and target 8,
//A solution set is:
//[1, 7]
//[1, 2, 5]
//[2, 6]
//[1, 1, 6]
package org.leituo.leetcode.backtracking;

import java.util.*;

/**
 * Created by leituo56 on 1/10/15.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        combinationSum2(result, list, num, target, 0);
        return result;
    }
    private void combinationSum2(List<List<Integer>> result, List<Integer> list,
                                 int[] num, int target, int start){
        if(target == 0)
            result.add(new LinkedList<Integer>(list));
        if(target < 0)
            return;
        for(int i = start; i< num.length; i++){
            if(i > start && num[i] == num[i-1])
                continue;
            list.add(num[i]);
            combinationSum2(result, list, num, target - num[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
    /* //too long
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return combinationSum2(num, target, 0);
    }
    private List<List<Integer>> combinationSum2(int[] num, int target, int start){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(start >= num.length)
            return result;
        int prev = -1;
        for(int i = start; i< num.length; i++){
            if(num[i] > target)
                break;
            if(prev == num[i])
                continue;//skip the condition that already
            prev = num[i];
            if(num[i] == target){
                List<Integer> single = new LinkedList<Integer>();
                single.add(num[i]);
                result.add(single);
                return result;
            }else{
                List<List<Integer>> subResult = combinationSum2(num, target - num[i], i + 1);
                for(List<Integer> list:subResult){
                    list.add(0, num[i]);
                    result.add(list);
                }
            }
        }
        return result;
    }
    */
}
