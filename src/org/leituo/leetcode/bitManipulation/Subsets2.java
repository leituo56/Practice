//Given a collection of integers that might contain duplicates, S, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,2], a solution is:
//
//[
//[2],
//[1],
//[1,2,2],
//[2,2],
//[1,2],
//[]
//]
package org.leituo.leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/3/15.
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new LinkedList<Integer>());
        Arrays.sort(num);
        int oldSize = 0;
        for(int i=0; i<num.length; i++){
            int start = (i>0 && num[i] != num[i-1]) ? 0 : oldSize;
            int size = result.size();
            for(int j = start; j < size; j++){
                List<Integer> newList = new LinkedList<Integer>(result.get(j));
                newList.add(num[i]);
                result.add(newList);
            }
            oldSize = size;
        }
        return result;
    }
}
