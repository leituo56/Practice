//Compare two version numbers version1 and version1.
//        If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//
//        You may assume that the version strings are non-empty and contain only digits and the . character.
//        The . character does not represent a decimal point and is used to separate number sequences.
//        For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
//        Here is an example of version numbers ordering:
//
//        0.1 < 1.1 < 1.2 < 13.37
package org.leituo.leetcode.string;

/**
 * Created by leituo56 on 12/19/14.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2))
            return 0;
        String[] v1List = version1.split("\\.");
        String[] v2List = version2.split("\\.");
        int len = Math.max(v1List.length, v2List.length);
        for (int i=0; i<len; i++){
            int num1 = (i >= v1List.length?0:Integer.parseInt(v1List[i]));
            int num2 = (i >= v2List.length?0:Integer.parseInt(v2List[i]));
            if(num1 > num2)
                return 1;
            else if(num1 < num2)
                return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers test = new CompareVersionNumbers();
        System.out.println(test.compareVersion("1.0", "1"));
    }
}
