//Given an array of integers that is already sorted in ascending order,
// find two numbers such that they add up to a specific target number.
//
//        The function twoSum should return indices of the two numbers such that they add up to the target,
//      where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
//      are not zero-based.
//
//        You may assume that each input would have exactly one solution.
//
//        Input: numbers={2, 7, 11, 15}, target=9
//        Output: index1=1, index2=2
package org.leituo.leetcode.arraysM;

/**
 * Created by leituo56 on 12/18/14.
 */
public class TwoSum2sorted {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        int[] result = new int[2];
        while(head < tail){
            if(numbers[head] + numbers[tail] > target){
                tail--;
            }else if(numbers[head] + numbers[tail] < target){
                head++;
            }else{
                result[0] = head;
                result[1] = tail;
                return result;
            }
        }
        return result;
    }
}
