//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
//OJ's undirected graph serialization:
//Nodes are labeled uniquely.
//
//We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
//As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
//The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
//First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
//Second node is labeled as 1. Connect node 1 to node 2.
//Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
//Visually, the graph looks like the following:
//
//   1
//  / \
// /   \
//0 --- 2
//      / \
//      \_/
package org.leituo.leetcode.others;

import java.util.*;

/**
 * Created by leituo56 on 1/10/15.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return node;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode runner = node;
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(node.label, result);
        queue.offer(runner);
        while(!queue.isEmpty()){
            runner = queue.poll();
            for(UndirectedGraphNode adj:runner.neighbors){
                int val = adj.label;
                if(!map.containsKey(val)){
                    UndirectedGraphNode newNode = new UndirectedGraphNode(val);
                    map.put(val, newNode);
                    queue.offer(adj);
                }//new adj if their not newed before
                map.get(runner.label).neighbors.add(map.get(val));
            }//clone neighbors
        }
        return result;
    }
}


 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
