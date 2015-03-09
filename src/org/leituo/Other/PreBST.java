package org.leituo.Other;

import org.leituo.leetcode.tree.SymmetricTree;

import java.util.Stack;

/**
 * Created by leituo56 on 3/8/15.
 */
public class PreBST {
    class Solution{
        public boolean possibleBST(int[] data){
            if(data == null || data.length<=1)
                return true;
            Stack<Integer> pivot = new Stack<Integer>();
            pivot.push(data[0]);
            boolean phaseLeft = true;  //true: left phase, false: right phase
            int noSmallerThan = Integer.MIN_VALUE;
            for (int i=1; i<data.length; i++){
                int cur = data[i];
                if (!(phaseLeft && cur < pivot.peek())) {
                    if (phaseLeft)
                        phaseLeft = false;
                    else if (cur < noSmallerThan)
                        return false;
                    while(!pivot.isEmpty() &&cur > pivot.peek()){
                        noSmallerThan = pivot.pop();
                    }
                }
                pivot.push(cur);
//                if (phaseLeft){
//                    if (cur < pivot.peek()){
//                        pivot.push(cur);
//                    }else {
//                        phaseLeft = false;
//                        while(!pivot.isEmpty() && cur > pivot.peek()){
//                            noSmallerThan = pivot.pop();
//                        }
//                        pivot.push(cur);
//                    }
//                }else{
//                    if(cur < noSmallerThan)
//                        return false;
//                    while(!pivot.isEmpty() &&cur > pivot.peek()){
//                        noSmallerThan = pivot.pop();
//                    }
//                    pivot.push(cur);
//                }
            }
            return true;
        }
    }
    public void test(){
        Solution t = new Solution();
        int[] a1 = {1,2,3};
        System.out.println(t.possibleBST(a1));
        int[] a2 = {2,1,3};
        System.out.println(t.possibleBST(a2));
        int[] a3 = {3,2,1,5,4,6};
        System.out.println(t.possibleBST(a3));
        int[] a4 = {1,3,4,2};
        System.out.println(t.possibleBST(a4));
        int[] a5 = {3,4,5,1,2};
        System.out.println(t.possibleBST(a5));
        int[] a6 = {4,1,2,3};
        System.out.println(t.possibleBST(a6));
        int[] a7 = {5,4,2,1,3,6,7};
        System.out.println(t.possibleBST(a7));
    }
    public static void main(String[] args) {
        PreBST preBST = new PreBST();
        preBST.test();
    }
}
