//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
// where the candidate numbers sums to T.

//The same repeated number may be chosen from C unlimited number of times.
//
//        Note:
//        All numbers (including target) will be positive integers.
//        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//        The solution set must not contain duplicate combinations.
//        For example, given candidate set 2,3,6,7 and target 7,
//        A solution set is:
//        [7]
//        [2, 2, 3]
package org.leituo.leetcode.backtracking;

import java.util.*;

/**
 * Created by leituo56 on 11/9/14.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates.length<1)
            return result;
        if (target < candidates[0])
            return result;
        for (int i=0;i<candidates.length;i++){
            if (candidates[i]==target){
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                result.add(list);
            }
        }
        //for num in candidates
        for (int i = 0; i <candidates.length ; i++) {
            if (candidates[i] > target)
                break;
            //result.add(cat(num, each(combinationSum(candidates, target - num)) ))
            int[] newCandidates = Arrays.copyOfRange(candidates, i, candidates.length);
            List<List<Integer>> subResult = combinationSum(newCandidates, target - candidates[i]);
            for (List<Integer> list:subResult){
                list.add(candidates[i]);
                Collections.sort(list);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] candidates = {2,3,6,7};
        List<List<Integer>> result = test.combinationSum(candidates, 7);
        for (List<Integer> list:result){
            System.out.print(Arrays.toString(list.toArray()));
            System.out.println();
        }
    }
}
