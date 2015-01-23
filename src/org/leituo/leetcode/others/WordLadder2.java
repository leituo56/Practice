//Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
package org.leituo.leetcode.others;

import java.util.*;

/**
 * Created by leituo56 on 1/23/15.
 */
public class WordLadder2 {
    class Solution{
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            List<List<String>> result = new LinkedList<List<String>>();
            Ladder endL = new Ladder(null, end);
            Queue<Ladder> queue = new LinkedList<Ladder>();
            queue.offer(endL);
            int curLevel = 1;
            int nextLevel = 0;
            while(!queue.isEmpty()){
                Set<String> visitedThisLevel = new HashSet<String>();
                for(int j = 0; j<curLevel; j++){//find all this level
                    Ladder curLadder = queue.poll();
                    for(int i=0; i<curLadder.word.length(); i++){
                        char[] temp = curLadder.word.toCharArray();
                        for(char c = 'a'; c<='z'; c++){//replace each char
                            temp[i] = c;
                            String curStr = new String(temp);
                            if(curStr.equals(start)){//match the start
                                List<String> list = new LinkedList<String>();
                                list.add(start);
                                Ladder runner = curLadder;
                                while(runner!=null){
                                    list.add(runner.word);
                                    runner = runner.parent;
                                }//traverse up
                                result.add(list);
                            }else if(dict.contains(curStr) && !curStr.equals(curLadder.word)){//not visited last level && not cur
                                Ladder newLadder = new Ladder(curLadder, curStr);
                                queue.offer(newLadder);
                                nextLevel++;
                                visitedThisLevel.add(curStr);
                            }
                        }
                    }
                }
                if(result.size()>0)
                    return result;
                dict.removeAll(visitedThisLevel);
                curLevel = nextLevel;
                nextLevel = 0;
            }
            return result;
        }
        class Ladder{
            Ladder parent;
            String word;
            Ladder(Ladder parent, String word){
                this.parent = parent;
                this.word = word;
            }
        }
    }
}
