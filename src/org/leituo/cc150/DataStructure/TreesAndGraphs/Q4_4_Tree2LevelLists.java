//4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at
//each depth (e.g., if you have a tree with depth D, you'll have D linked lists
package org.leituo.cc150.DataStructure.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 11/13/14.
 */
public class Q4_4_Tree2LevelLists {
    //BFS
    List<List<Tree>> createLevelLinkedList(Tree root){
        List<List<Tree>> result = new ArrayList<List<Tree>>();
        if(root == null)
            return result;
        LinkedList<Tree> queue = new LinkedList<Tree>();

        queue.add(root);
        while (!queue.isEmpty()){
            List<Tree> line = new LinkedList<Tree>();
            queue.add(null);
            while (!queue.isEmpty()){
                Tree elem = queue.removeFirst();
                if (elem == null)
                    break;

                line.add(elem);
                if (elem.left!=null)
                    queue.add(elem.left);
                if (elem.right!=null)
                    queue.add(elem.right);

            }
            result.add(line);
        }
        return result;
    }
}
