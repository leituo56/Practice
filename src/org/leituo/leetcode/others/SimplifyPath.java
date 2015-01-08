//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//click to show corner cases.
//
//Corner Cases:
//Did you consider the case where path = "/../"?
//In this case, you should return "/".
//Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//In this case, you should ignore redundant slashes and return "/home/foo".
package org.leituo.leetcode.others;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by leituo56 on 1/7/15.
 */
public class SimplifyPath {
    //stack solution
    public String simplifyPath(String path) {
        if(path == null)
            return null;
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        String[] folders = path.split("/");
        for(String folder:folders){
            if(folder.isEmpty() || folder.equals("."))
                continue;
            if(folder.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.push(folder);
            }
        }
        if(stack.isEmpty())
            stack.push("");
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
            result.insert(0, "/");
        }
        return result.toString();
    }

    //two pointer solution
    public String simplifyPath2(String path) {
        StringBuilder result = new StringBuilder();
        LinkedList<String> folders = new LinkedList<String>();
        int len = path.length();
        int start = 0;
        int end = start;
        while(start < len && end < len){
            while(start < len && path.charAt(start)=='/'){
                start++;
            }//stop at first char which is not '/'
            end = start;
            while(end < len && path.charAt(end)!='/'){
                end++;
            }//stop at next '/'

            String cur = path.substring(start, end);
            if(cur.equals("..")){
                if(!folders.isEmpty()){
                    folders.removeLast();
                }
            }else if(!cur.equals(".")){
                folders.add(cur);
            }
            start = end;
        }
        for(String folder:folders){
            if(folder.isEmpty())
                continue;
            result.append("/");
            result.append(folder);
        }
        if(result.length() == 0)
            result.append("/");
        return result.toString();
    }
}
