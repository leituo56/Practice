package org.leituo.leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 12/18/14.
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        return combineHelper(1, n, k);
    }
    private List<List<Integer>> combineHelper(int start, int end, int size){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(size==1){
            for(int i=start; i<=end; i++){
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                result.add(list);
            }
            return result;
        }
        for(int i=start;i<=end - size + 1;i++){
            List<List<Integer>> temp = combineHelper(i+1, end, size-1);
            for(List<Integer> list:temp){
                list.add(0, i);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Combination test = new Combination();
        List<List<Integer>> result = test.combine(4, 3);
        for (List<Integer> list:result){
            for (int elem:list){
                System.out.print(elem + ",");
            }
            System.out.println();
        }
    }
}
