//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//        The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
//        By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
//        Note:
//        The read function will only be called once for each test case.
package org.leituo.leetcode.stringM;

/**
 * Created by leituo56 on 12/19/14.
 */
public class ReadNCharactersGivenRead4 {
    public int read4(char[] buffer){
        return 0;
    }
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int sum = 0;
        while(n>0){
            char[] temp = new char[4];
            int num = read4(temp);
            int bytes = Math.min(n, num);
            for(int i=0; i<bytes; i++)
                buf[sum + i] = temp[i];
            sum += bytes;
            n = n - bytes;
            if(num < 4)
                return sum;
        }
        return sum;
    }
}
