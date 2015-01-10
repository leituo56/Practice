//implement int sqrt(int x).
//
//Compute and return the square root of x.
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 1/9/15.
 */
public class SqrtX {
    //newton, 2y = x + k/x, y = (x + k/x)/2
    public int sqrt(int x) {
        if(x <= 0)
            return 0;
        double cur = 0.0;
        double next = 1.0;
        while(cur!=next){
            cur = next;
            next = (cur + x/cur)/2;
        }
        return (int) next;
    }

    //binary search
    public int sqrt2(int x) {
        if(x == 0 || x == 1)
            return x;
        int left = 0;
        int right = x;
        int result = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(mid == x/mid){
                return mid;
            }else if(mid  > x/mid){//at left side
                right = mid - 1;
            }else{//at right side;
                left = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}
