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
    public int read(char[] buf, int n) {
        
        int ans=0;
        char[] temp=new char[4];
        
        while(true)
        {
            int num=read4(temp);
            int delta=Math.min(num,n-ans);
            
            if(delta==0)
                break;
            
            for(int i=ans;i<ans+delta;i++)
                buf[i]=temp[i-ans];
            
            ans=ans+delta;

        }
        
        return ans;
        
    }
}