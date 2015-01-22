//You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
//
//For example, given:
//S: "barfoothefoobarman"
//L: ["foo", "bar"]
//
//You should return the indices: [0,9].
//(order does not matter).
package org.leituo.leetcode.stringH;

import java.util.*;

/**
 * Created by leituo56 on 1/22/15.
 */
public class SubstringWithConcatenationOfAllWords {
    class Solution{
        public List<Integer> findSubstring(String S, String[] L) {
            if(S == null || L == null || L.length == 0)
                return null;
            List<Integer> result = new LinkedList<Integer>();
            Map<String, Integer> map = new HashMap<String, Integer>();//String, occurrence
            for(String word:L){
                map.put(word, map.containsKey(word)?map.get(word)+1 : 1);
            }//init occurrence of each word
            int step = L[0].length();
            for(int i = 0; i < S.length(); i++){
                if(arrOfWords(i, S, map, step, L.length))
                    result.add(i);
            }
            return result;
        }
        private boolean arrOfWords(int index, String S, Map<String, Integer> map, int step, int len){
            Map<String, Integer> counter = new HashMap<String, Integer>();
            for(int i = index; i < index + len * step; i = i + step) {
                String query = S.substring(i, Math.min(i + step, S.length()));
                if(map.containsKey(query)){
                    counter.put(query, counter.containsKey(query)?counter.get(query)+1 : 1);
                }else{
                    return false;//cur not match
                }
            }
            return counter.equals(map);
        }
    }
    public void test(){
        Solution s = new Solution();
        String[] L = {"a", "a"};
        List<Integer> l = s.findSubstring("a", L);
        for (int item:l){
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords test = new SubstringWithConcatenationOfAllWords();
        test.test();
    }
}
