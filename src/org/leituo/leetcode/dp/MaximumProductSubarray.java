//Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//For example, given the array [2,3,-2,4],
//the contiguous subarray [2,3] has the largest product = 6.
package org.leituo.leetcode.dp;

/**
 * Created by leituo56 on 1/7/15.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        //for each index in array A,
        //store max product and min product until current index
        //maxPos = max(cur, cur * maxPos, cur * minNeg)
        //minNeg = min(cur, cur * minNeg, cur * maxPos)
        if(A.length == 0)
            return 0;
        int result = Integer.MIN_VALUE;
        int maxPos = 1;//max positive product include this index
        int minNeg = 1;//min negative product include this index
        for(int elem:A){
            int tempMax = maxPos;
            // previous==0, elem>0, elem < 0
            maxPos = Math.max(elem, Math.max(elem * maxPos, elem * minNeg));
            minNeg = Math.min(elem, Math.min(elem * tempMax, elem * minNeg));
            result = Math.max(maxPos, result);
        }
        return result;
    }

    //Bad implementation
    public int maxProduct2(int[] A) {
        //split by 0s
        //max to track biggest product
        //firstNegative to track the head negative product, lastNegative to track the tail
        //if cur is negative, try to devide first/last negative which abs is smaller.
        //special case when there's only 1 negative
        if(A.length == 1)
            return A[0];
        int max = Integer.MIN_VALUE;
        int firstNeg = 0;
        int lastNeg = 0;
        int cur = 0;
        boolean hasPositive = false;
        for(int i = 0; i<A.length; i++){
            if(A[i] == 0){
                max = Math.max(max, 0);
                if(cur < 0 && hasPositive){
                    cur = cur / choose(firstNeg, lastNeg);
                }
                max = Math.max(max, cur);
                cur = 0;
                firstNeg = 0;
                lastNeg = 0;
                hasPositive = false;
            }else{ // <0 or >0
                cur = cur==0?A[i]:cur * A[i];//copy A[i] when first appear.else multiply
                max = Math.max(max, cur);
                if(cur > 0)
                    hasPositive = true;
                if(firstNeg >= 0)//stop at first negative number
                    firstNeg = firstNeg==0?A[i]:firstNeg * A[i];
                if(A[i] < 0){//renew when meet an negative
                    lastNeg = A[i];
                }else{
                    lastNeg = lastNeg * A[i];
                    hasPositive = true;
                }
            }
        }
        if(cur < 0 && hasPositive){
            cur = cur / choose(firstNeg, lastNeg);
        }
        max = Math.max(max, cur);
        return max;
    }
    private int choose(int firstNeg, int lastNeg){
        if(firstNeg == 0)
            return lastNeg;
        if(lastNeg == 0)
            return firstNeg;
        return Math.max(firstNeg, lastNeg);
    }

    public static void main(String[] args) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] data = {-1,1,2,1};
        System.out.println(test.maxProduct(data));
    }
}
