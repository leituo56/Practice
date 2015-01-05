//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//
//Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
//
//Note:
//The solution is guaranteed to be unique.
package org.leituo.leetcode.greedy;

/**
 * Created by leituo56 on 1/4/15.
 */
public class GasStation {
    // If I start from A and can not reach B, any point between [A,B] is impossible to reach B
    // total gas must be greater than total cost, if that, there must be at least 1 solution
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remains = 0;
        int accumulate = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            remains += gas[i] - cost[i];
            accumulate += gas[i] - cost[i];
            if(remains < 0){
                start = i + 1;
                remains = 0;
            }
        }
        if(accumulate < 0)
            return -1;
        return start % gas.length;
    }
}
