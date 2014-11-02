//[
//    [1],
//    [1,1],
//    [1,2,1],
//    [1,3,3,1],
//    [1,4,6,4,1]
//]
package org.leituo.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leituo56 on 11/1/14.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows<=0)
            return result;
        List<Integer> oldList = new ArrayList<Integer>();
        oldList.add(1);
        result.add(oldList);
        for(int i = 1;i<numRows;i++){
            oldList = result.get(i-1);
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(1);
            for(int j=1;j<oldList.size();j++){
                newList.add(oldList.get(j) + oldList.get(j-1));
            }
            newList.add(oldList.get(oldList.size()-1));
            result.add(newList);
        }
        return result;
    }
}

