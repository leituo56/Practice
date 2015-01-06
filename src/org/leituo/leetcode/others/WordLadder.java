//Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
//
//Note:
//Return 0 if there is no such transformation sequence.
//All words have the same length.
//All words contain only lowercase alphabetic characters.
package org.leituo.leetcode.others;

import java.util.*;

/**
 * Created by leituo56 on 1/5/15.
 */
public class WordLadder {
    //each word has only 26 choice of ladder for each letter, thus word.length * 26,
    // this is a reasonable amount to build graph
    // L * 26 * N
    public int ladderLength(String start, String end, Set<String> dict){
        if(start==null || end==null || start.length()!=end.length())
            return 0;
        int len = start.length();
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(start);
        visited.add(start);

        int level = 1;
        int curLvRemains = 1;
        int nextLvRemains = 0;
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            curLvRemains--;
            for (int i = 0; i < len; i++) {
                char[] curWord = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    curWord[i] = c;
                    String temp = new String(curWord);
                    if(temp.equals(end))
                        return level + 1;
                    if (dict.contains(temp) && !visited.contains(temp)) {
                        queue.offer(temp);
                        visited.add(temp);
                        nextLvRemains++;
                    }
                }
            }
            if(curLvRemains==0){
                curLvRemains = nextLvRemains;
                nextLvRemains = 0;
                level++;
            }
        }
        return 0;
    }

    //Intuit, word graph approach, O(N*N*L)
    public int ladderLength2(String start, String end, Set<String> dict) {
        if(isOne(start, end))
            return 2;
        GraphNode startNode = new GraphNode(start);
        GraphNode endNode = new GraphNode(end);
        //Build graph, wordsNum * wordsNum
        List<GraphNode> nodes = new LinkedList<GraphNode>();
        nodes.add(startNode);
        nodes.add(endNode);
        for(String setStr:dict){
            if(setStr.equals(start) || setStr.equals(end))
                continue;
            GraphNode newNode = new GraphNode(setStr);
            for(GraphNode listItem:nodes){
                if(isOne(setStr, listItem.data))
                    bond(newNode, listItem);
            }
            nodes.add(newNode);
        }

        //BFS
        if(startNode.around.size() == 0 || endNode.around.size() == 0)
            return 0;
        nodes.clear();//served as queue from now on;
        nodes.add(startNode);
        startNode.visited = true;
        int level = 1;
        while(!nodes.isEmpty()){
            nodes.add(null);
            while(!nodes.isEmpty()){
                GraphNode runner = nodes.remove(0);
                if(runner == null)
                    break;
                if(runner == endNode)
                    return level;
                for(GraphNode adj:runner.around){
                    if(!adj.visited){
                        nodes.add(adj);
                        adj.visited = true;
                    }
                }
            }
            level++;
        }
        return 0;
    }
    private void bond(GraphNode node1, GraphNode node2){
        node1.setAdj(node2);
        node2.setAdj(node1);
    }
    private boolean isOne(String s1, String s2){
        int diff = 0;
        int index = 0;
        int len = s1.length();
        while(diff <= 1 && index < len){
            if(s1.charAt(index)!=s2.charAt(index)){
                if(diff==1)
                    return false;
                diff++;
            }
            index++;
        }
        return true;
    }
    class GraphNode{
        boolean visited;
        List<GraphNode> around = new LinkedList<GraphNode>();
        String data;
        GraphNode(String data){
            this.data = data;
        }
        void setAdj(GraphNode node){
            around.add(node);
        }
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        String s1 = "hot";
        String s2 = "dog";
        Set<String> set = new HashSet();
        set.add("hot");
        set.add("dog");
        set.add("dot");
        System.out.println(test.ladderLength(s1, s2, set));
    }
}
