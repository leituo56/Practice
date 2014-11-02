// get Kth line
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
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for(int i=0;i<rowIndex;i++){
            for(int j=0;j<result.size()-1;j++){
                result.set(j, result.get(j) + result.get(j+1));
            }
            result.add(0,1);
        }
        return result;
    }
}
