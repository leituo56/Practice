//4.2 Given a directed graph, design an algorithm to find out whether there is a route between two nodes
package org.leituo.cc150.DataStructure.TreesAndGraphs;

import java.util.LinkedList;

/**
 * Created by leituo56 on 11/2/14.
 */
public class Q4_2_GraphFind {
    public boolean findGraph(SingleGraph start, SingleGraph end){
        LinkedList<SingleGraph> queue = new LinkedList<SingleGraph>();
        queue.add(start);
        while (!queue.isEmpty()){
            SingleGraph temp = queue.removeFirst();
            System.out.println(temp.key);
            if (temp.key == end.key)
                return true;
            temp.visited = true;
            for(SingleGraph s:temp.nodes){
                if (s.visited == false && !queue.contains(s)){
                    queue.add(s);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Q4_2_GraphFind test = new Q4_2_GraphFind();
        SingleGraph s1 = new SingleGraph(1);
        SingleGraph s2 = new SingleGraph(2);
        SingleGraph s3 = new SingleGraph(3);
        SingleGraph s4 = new SingleGraph(4);
        SingleGraph s5 = new SingleGraph(5);
        SingleGraph s6 = new SingleGraph(6);
        s3.attach(s1);
        s1.attach(s2);
        s1.attach(s4);
        s2.attach(s5);
        s2.attach(s6);
        s4.attach(s2);
        s5.attach(s4);
        s6.attach(s5);

        //System.out.println(test.findGraph(s1, s3));
        System.out.println(test.findGraph(s6, s2));


    }
}
