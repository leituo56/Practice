//Given an array of words and a length L, format the text such that each line has exactly L characters and is fully
// (left and right) justified.
//
//You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
// Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line
// do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left justified and no extra space is inserted between words.
//
//For example,
//words: ["This", "is", "an", "example", "of", "text", "justification."]
//L: 16.
//
//Return the formatted lines as:
//[
//"This    is    an",
//"example  of text",
//"justification.  "
//]
//Note: Each word is guaranteed not to exceed L in length.
package org.leituo.leetcode.stringH;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leituo56 on 1/22/15.
 */
public class TextJustification {
    class Solution{
        //concise solution
        public List<String> fullJustify(String[] words, int L) {
            List<String> result = new LinkedList<String>();
            for(int start = 0, end; start < words.length; start = end){
                int len = -1;
                for(end = start; end < words.length && (len + 1 + words[end].length()) <= L; end++){
                    len += 1 + words[end].length();
                }//find end, calculate len
                StringBuilder line = new StringBuilder(words[start]);//add first word
                int space = 1;
                int extra = 0;
                if(start + 1 != end && end != words.length){//not only 1 char && not last line
                    space = (L - len) / (end - start - 1) + 1;//+1 beacuse we add 1 space between each word in len
                    extra = (L - len) % (end - start - 1);
                }
                for(int i = start + 1; i < end; i++){
                    for(int s = 0; s < space; s++)
                        line.append(' ');//add regular spaces
                    if(extra-- > 0)
                        line.append(' ');//add extra spaces
                    line.append(words[i]);
                }
                int pad = L - line.length();
                while(pad-- > 0)
                    line.append(' ');//pad tail spaces.
                result.add(line.toString());
            }
            return result;
        }
    }
    class SolutionBasic{
        public List<String> fullJustify(String[] words, int L) {
            List<String> result = new LinkedList<String>();
            int start = 0;
            int end = 0;
            int lineSum = 0;
            while(end < words.length){
                if((lineSum==0?lineSum:lineSum + 1) + words[end].length() <= L){
                    lineSum += lineSum==0?words[end].length():1 + words[end].length();
                    end++;
                }else{
                    lineSum = 0;
                    result.add(justify(words, start, end - 1, L, false));
                    start = end;
                }
            }
            result.add(justify(words, start, end - 1, L, true));
            return result;
        }
        private String justify(String[] words, int start, int end, int L, boolean last){
            StringBuilder result = new StringBuilder();
            int num = end - start + 1;
            if(num == 1 || last){//squeeze at left
                for(int i=start; i<=end; i++){
                    result.append(words[i]);
                    if(result.length() < L)
                        result.append(" ");
                }
                while(result.length() < L)
                    result.append(" ");
                return result.toString();
            }

            int len = 0;
            for(int i=start; i<=end; i++){
                len += words[i].length();
            }

            int space = (L - len)/(num - 1);
            int shortSpace = L - len - space * (num - 1);
            for(int i=start; i<=end; i++){
                result.append(words[i]);
                for(int j=0; j<space && result.length() < L;j++){
                    result.append(" ");
                }
                if(shortSpace > 0){
                    result.append(" ");
                    shortSpace--;
                }
            }
            return result.toString();
        }
    }
}
