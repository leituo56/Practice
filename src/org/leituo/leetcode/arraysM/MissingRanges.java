//Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
//
//        For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
package org.leituo.leetcode.arraysM;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/1/15.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new LinkedList<String>();
        for (int elem : A) {
            if (elem > upper)
                break;
            if (elem < lower) {
                continue;
            }else if (elem == lower) {
                lower = elem + 1;
            }else { // elem > lower
                result.add(range(lower, elem - 1));
                lower = elem + 1;
            }
        }
        if(lower <= upper)
            result.add(range(lower, upper));
        return result;
    }
    private String range(int start, int end){
        if(start==end){
            return start + "";
        }else {
            return start + "->" + end;
        }
    }

    public static void main(String[] args) {
        MissingRanges test = new MissingRanges();
        int[] data = {0, 1, 3, 50, 75};
        List<String> result = test.findMissingRanges(data, 0, 99);
        for (String elem:result){
            System.out.println(elem);
        }
    }
}
