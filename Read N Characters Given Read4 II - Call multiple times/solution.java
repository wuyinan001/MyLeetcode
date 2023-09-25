/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int readIndex=0,writeIndex=0;
    char[] buff=new char[4];
    
    public int read(char[] buf, int n) {
        
        for(int i=0;i<n;i++)
        {
            if(readIndex==writeIndex)
            {
                readIndex=0;
                writeIndex=read4(buff);
                
                if(writeIndex==0)
                    return i;
            }
            
            buf[i]=buff[readIndex++];
        }
        
        return n;
    }
}