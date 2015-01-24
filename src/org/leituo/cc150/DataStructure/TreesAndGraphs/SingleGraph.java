package org.leituo.cc150.DataStructure.TreesAndGraphs;

import java.util.ArrayList;

/**
 * Created by leituo56 on 11/2/14.
 */
public class SingleGraph {
    public int key;
    public ArrayList<SingleGraph> nodes;
    public boolean visited;

    public SingleGraph(int key) {
        this.key = key;
        nodes = new ArrayList<SingleGraph>();
        visited = false;
    }

    public boolean attach(SingleGraph s){
        if (this.nodes.contains(s))
            return false;
        this.nodes.add(s);
        return true;
    }
}
