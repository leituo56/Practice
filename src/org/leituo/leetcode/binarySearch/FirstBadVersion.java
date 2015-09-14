// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
// of your product fails the quality check. Since each version is developed based on the previous version, all the
// versions after a bad version are also bad.
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
// ones to be bad.
// You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
// find the first bad version. You should minimize the number of calls to the API.

package org.leituo.leetcode.binarySearch;

/**
 * Created by tuolei on 9/11/15.
 */
public class FirstBadVersion {
    // Binary search problems
    // if bad, find the left part
    // if not, find the right part
    // stop when left > right, which last finded bad version is at right + 1

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    boolean isBadVersion(int version) {return false;}

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left <= right) {
            int target = left + (right - left) / 2;
            boolean cur = isBadVersion(target);
            if(cur) {
                right = target - 1;
            } else {
                left = target + 1;
            }
        }
        return right + 1;
    }
}
