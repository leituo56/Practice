//Given n items with size A[i] and value V[i], and a backpack with size m. What's the maximum value can you put into the backpack?
//
//Example
//Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
package org.leituo.lintcode.dp;

/**
 * Created by leituo56 on 4/23/15.
 */
public class BackPack2 {
    class Solution {
        /**
         * @param m: An integer m denotes the size of a backpack
         * @param A & V: Given n items with size A[i] and value V[i]
         * @return: The maximum value
         */
        public int backPackII(int m, int[] A, int V[]) {
            if(m<=0 || A==null || V==null || A.length == 0 || V.length==0)
                return 0;
            int[] prevSolution = new int[m+1];
            for(int i=0; i<A.length; i++){
                int[] curSolution = new int[m+1];
                for(int j=0; j<=m; j++){
                    if(A[i] > j){
                        curSolution[j] = prevSolution[j];
                    }else{
                        curSolution[j] = Math.max(prevSolution[j], V[i] + prevSolution[j - A[i]]);
                    }
                }
                prevSolution = curSolution;
            }
            return prevSolution[m];
        }
    }
}
