//Given an array of strings, return all groups of strings that are anagrams.
//  means string have same set of characters. 'aba' 'baa';
//        Note: All inputs will be in lower-case.
package org.leituo.leetcode.stringM;

import java.util.*;

/**
 * Created by leituo56 on 12/19/14.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> result = new LinkedList<String>();
        for(int i=0; i<strs.length;i++){
            String sorted = sortStr(strs[i]);
            if(map.containsKey(sorted)){
                if(map.get(sorted)>=0){
                    result.add(strs[map.get(sorted)]);
                    map.put(sorted, -1);
                }
                result.add(strs[i]);
            }else {
                map.put(sorted, i);
            }
        }
        return result;
    }
    private String sortStr(String src){
        char[] chars = src.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Anagrams test = new Anagrams();
        String[] data = {"", ""};
        List<String> list = test.anagrams(data);
        for (String item:list){
            System.out.println(item);
        }
    }
}
