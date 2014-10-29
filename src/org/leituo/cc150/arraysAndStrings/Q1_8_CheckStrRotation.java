//  1.8 Assume you have a method isSubstring which checks if one word is asubstring of another.
//  Given two strings, si and s2, write code to check If s2 is a rotation of si using only one call to
//  isSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
package org.leituo.cc150.arraysAndStrings;

/**
 * Created by leituo56 on 10/28/14.
 */
public class Q1_8_CheckStrRotation {
    public boolean isRotationStr(String src, String target){
        if (src.length() != target.length())
            return false;
        String cat = target + target;
        return this.isSubstring(cat, src);
    }

    //a basic method question provide
    public boolean isSubstring(String src, String target){
        return src.contains(target);
    }
    public static void main(String[] args) {
        Q1_8_CheckStrRotation test = new Q1_8_CheckStrRotation();
        System.out.println(test.isRotationStr("waterbottLe", "erbottLewat"));
        System.out.println(test.isRotationStr("waterbottLe", "rebottLewat"));
    }
}
