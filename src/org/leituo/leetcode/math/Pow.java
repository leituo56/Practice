//Implement pow(x, n).
package org.leituo.leetcode.math;

/**
 * Created by leituo56 on 1/3/15.
 */
public class Pow {
    public double pow(double x, int n) {
        if(n==0)
            return (double)1.0;
        double temp = pow(x, n/2);
        if(n % 2==0){
            return temp * temp;
        }else{
            if(n > 0)
                return x * temp * temp;
            else
                return temp * temp / x;
        }
    }
}
