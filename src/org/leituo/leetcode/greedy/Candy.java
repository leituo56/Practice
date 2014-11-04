//There are N children standing in a line. Each child is assigned a rating value.

//You are giving candies to these children subjected to the following requirements:
//
//        Each child must have at least one candy.
//        Children with a higher rating get more candies than their neighbors.
//        What is the minimum candies you must give?
package org.leituo.leetcode.greedy;

import java.util.Arrays;

/**
 * Created by leituo56 on 11/4/14.
 */
public class Candy {
    public int candy(int[] ratings) {
        int sum = 0;
        int len = ratings.length;
        if(len==1)
            return 1;
        int[] candies = new int[len];
        if(ratings[0] <= ratings[1])
            candies[0] = 1;
        if(ratings[len-1] <= ratings[len-2])
            candies[len-1] = 1;

        //System.out.println(Arrays.toString(candies));

        for(int i=1;i<len-1;i++){
            if(ratings[i]<=ratings[i-1] && ratings[i]<=ratings[i+1])
                candies[i] = 1;
        }
        //System.out.println(Arrays.toString(candies));

        for(int i=1;i<len;i++){
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1]+1;
        }
        //System.out.println(Arrays.toString(candies));

        for(int i=len-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i+1]+1, candies[i]);
            }
        }
        //System.out.println(Arrays.toString(candies));

        for (int i = 0; i < len; i++) {
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Candy test = new Candy();
        int[] input = {1,2,2};
        System.out.println(test.candy(input));
    }
}
