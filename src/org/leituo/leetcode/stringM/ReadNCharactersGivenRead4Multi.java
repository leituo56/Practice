//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters
// left in the file.
//
//By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
//Note:
//The read function may be called multiple times.
package org.leituo.leetcode.stringM;

/**
 * Created by leituo56 on 1/1/15.
 */
public class ReadNCharactersGivenRead4Multi {
    public int read4(char[] buffer){
        return 0;
    }
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int offset = 0;
    private int remains = 0;
    char[] buffer = new char[4];
    private boolean EOF = false;

    public int read(char[] buf, int n) {
        int readed = 0;
        while(readed < n && (remains != 0 || !EOF)){
            int num;
            if(remains == 0) {//new buffer
                offset = 0;
                num = read4(buffer);
                if(num < 4)
                    EOF = true;
            }else{//need to continue read buffer
                num = remains;
            }
            int bytes = Math.min(n - readed, num);
            for(int i=0; i<bytes; i++) {
                buf[readed++] = buffer[offset + i];
            }
            remains = num - bytes;
            if(remains!=0) {
                offset += bytes;
            }
        }
        return readed;
    }
}
