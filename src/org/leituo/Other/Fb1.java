package org.leituo.Other;

import java.util.*;

/**
 * Created by leituo56 on 1/30/15.
 */
public class Fb1 {
    public List<List<Integer>> posScore(int[] scores, int sum){
        Arrays.sort(scores);//to_do, not every time
        Map<Integer, List<List<Integer>> > map = new HashMap<Integer, List<List<Integer>> >();
        return posScore(scores, sum, map);
    }
    private List<List<Integer>> posScore(int[] scores, int sum, Map<Integer, List<List<Integer>>> map){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(map.containsKey(sum)){
            if(map.get(sum)==null)
                return result;
            return map.get(sum);
        }

        //loop
        for(int i=0; i<scores.length; i++){
            int cur = scores[i];//3
            if(cur == sum){//2==2
                List<Integer> newList = new LinkedList<Integer>();
                newList.add(cur);
                result.add(newList);
                continue;
            }
            if(cur > sum)//
                break;
            int newSum = sum - i;//2
            List<List<Integer>> temp;
            if(map.containsKey(newSum)){
                if(map.get(newSum)==null)
                    continue;
                temp = map.get(newSum);
            }else{
                temp = posScore(scores, newSum, map);//return an array //1
            }
            for(List<Integer> list:temp){
                List<Integer> subResult = new LinkedList<Integer>();
                subResult.add(cur);
                subResult.addAll(list);
                result.add(subResult);
            }
        }
        if(result.size()==0)
            map.put(sum, null);
        else
            map.put(sum, result);
        return result;
    }
}
