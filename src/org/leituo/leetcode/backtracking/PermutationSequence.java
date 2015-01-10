//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
//Note: Given n will be between 1 and 9 inclusive.
package org.leituo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leituo56 on 1/9/15.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        // save 1..n to a list, calculate position of cur digit, and then modify the list
        // next layer elems nextElems= (n-1)!
        // indexOfStr = k - 1 / nextElems
        // k = k - 1 % nextElems
        StringBuilder result = new StringBuilder();
        List<Integer> data = new ArrayList<Integer>();
        for(int i = 1; i<=n; i++){
            data.add(i);
        }
        for(int i = n; i > 0; i--){
            int next = fact(i-1); // num of elemts for next level
            int index = (k - 1) / next;
            result.append(data.remove(index));
            k = (k - 1) % next + 1;
        }
        return result.toString();
    }
    public int fact(int n){
        int result = 1;
        while(n > 1){
            result *= n;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        System.out.println(test.getPermutation(2, 1));
    }
}
