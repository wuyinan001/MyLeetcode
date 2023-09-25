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
    
    int index=0;
    List<Character> list=new ArrayList();
    boolean end=false;
    
    public int read(char[] buf, int n) {
        
        while(!end)
        {
            char[] temp=new char[4];
            int length=read4(temp);
            
            if(length==0)
                end=true;
            else
            {
                for(int i=0;i<length;i++)
                    list.add(temp[i]);
            }
        }
        
        int ans=0;
        
        int numToRead=Math.min(n,list.size()-index);
        
        for(int i=index;i<index+numToRead;i++)
        {
            buf[i-index]=list.get(i);
        }
        
        index+=numToRead;
        return numToRead;
    }
}