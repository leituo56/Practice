//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
package org.leituo.leetcode.greedy;

/**
 * Created by leituo56 on 1/16/15.
 */
public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int min = prices[0];
        int maxLeft = 0;
        for(int i = 1; i < len; i++){
            min = Math.min(min, prices[i]);
            maxLeft = Math.max(maxLeft, prices[i] - min);
            left[i] = maxLeft;
        }
        int max = prices[len - 1];
        int maxRight = 0;
        for(int i = len - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            maxRight = Math.max(maxRight, max - prices[i]);
            right[i] = maxRight;
        }
        int result = 0;
        for(int i = 0; i < len; i++){
            result = Math.max(result, left[i] + right[i]);
        }
        return result;
    }
}
