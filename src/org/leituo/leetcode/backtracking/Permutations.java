//Given a collection of numbers, return all possible permutations.
//
//        For example,
//        [1,2,3] have the following permutations:
//        [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
package org.leituo.leetcode.backtracking;

import java.util.*;

/**
 * Created by leituo56 on 12/8/14.
 */
public class Permutations {
    //Strait forward, bad for memory use
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> remain = new ArrayList<Integer>();
        for (int elem:num){
            remain.add(elem);
        }

        addPermute(result, new ArrayList<Integer>(), remain);
        return result;
    }
    private void addPermute(List<List<Integer>> result, List<Integer> base,  List<Integer> remain){
        if(remain.size()==0){
            result.add(base);
        }else {
            for (int i=0;i<remain.size();i++){
                ArrayList<Integer> baseNew = new ArrayList<Integer>(base);
                ArrayList<Integer> remainNew = new ArrayList<Integer>(remain);
                baseNew.add(remainNew.remove(i));

                addPermute(result, baseNew, remainNew);
            }
        }
    }

    //Swap apporach, better memory
    public List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        addPermute2(result, 0, num);
        return result;
    }
    private void addPermute2(List<List<Integer>> result, int start, int[] num){
        if(start>=num.length-1){
            List<Integer> data = new ArrayList<Integer>();
            for (int elem:num){
                data.add(elem);
            }
            result.add(data);
        }else {
            for (int i=start;i<num.length;i++){
                swap(num, start, i);
                addPermute2(result, start+1, num);
                swap(num, start, i);
            }
        }
    }
    private void swap(int[] num, int i1, int i2){
        int temp = num[i1];
        num[i1] = num[i2];
        num[i2] = temp;
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        int[] data = {1,2,3};
        List<List<Integer>> result = test.permute2(data);
        for (List<Integer> list:result){
            for (Integer elem:list){
                System.out.print(elem + ",");
            }
            System.out.println();
        }
    }
}
