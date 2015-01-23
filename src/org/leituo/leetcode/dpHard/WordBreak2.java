//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//
//A solution is ["cats and dog", "cat sand dog"].
package org.leituo.leetcode.dpHard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by leituo56 on 1/22/15.
 */
public class WordBreak2 {
    class Solution{
        public List<String> wordBreak(String s, Set<String> dict) {
            List<String> result = new LinkedList<String>();
            boolean[] possible = new boolean[s.length() + 1];
            possible[s.length()] = true;
            for(int i = s.length() - 1; i>=0; i--){
                for(int j = s.length(); j>i; j--){
                    if(possible[i])
                        break;
                    possible[i] = possible[j] && dict.contains(s.substring(i, j));
                }
            }
            wordBreak(s, dict, 0, possible, result, "");
            return result;
        }
        private void wordBreak(String s, Set<String> dict, int start, boolean[] possible, List<String> result, String temp){
            if(start >= s.length()){
                result.add(temp.trim());
                return;
            }
            for(int i = start; i < s.length(); i++){
                if(possible[i+1] && dict.contains(s.substring(start, i+1))){
                    wordBreak(s, dict, i+1, possible, result, temp + s.substring(start, i+1) + " ");
                }
            }
        }
    }

    //Bad
    class SolutionTLE{
        HashSet<String>[] data;
        public List<String> wordBreak(String s, Set<String> dict) {
            List<String> result = new LinkedList<String>();
            List<String> list = new LinkedList<String>();
            data = new HashSet[s.length()];
            for (int i = 0; i < data.length; i++){
                data[i] = new HashSet<String>();
            }
            wordBreak(s, dict, 0, result, list);
            return result;
        }
        private void wordBreak(String s, Set<String> dict, int start, List<String> result, List<String> list){
            if(start >= s.length()){
                StringBuilder entry = new StringBuilder();
                while(!list.isEmpty()){
                    entry.append(list.remove(0));
                    if(!list.isEmpty())
                        entry.append(" ");
                }
                result.add(entry.toString());
                return;
            }//sucess condition
            if(data[start].size() == 0){
                for(int i = start; i<s.length(); i++){
                    String cur = s.substring(start, i);
                    if(dict.contains(cur)){
                        data[start].add(cur);
                        list.add(cur);
                        wordBreak(s, dict, start + cur.length(), result, list);
                        list.remove(list.size()-1);
                    }
                }
            }else{
                for(String word:data[start]){
                    list.add(word);
                    wordBreak(s, dict, start + word.length(), result, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
