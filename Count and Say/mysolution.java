class Solution {
    public String countAndSay(int n) {
        String result="1";
        
        for(int i=2;i<=n;i++)
        {
            result=convertMultiChar(result);
        }
        
        return result;
    }
    
    // Convert string of single char
    private String convertSingleChar(String s)
    {
        int n=s.length();
        String s1=s.substring(0,1);
        
        return n+s1;
    }
    
    // Convert string of multiple chars
    private String convertMultiChar(String s)
    {
        int n=s.length();
        
        String result="";
        
        int i=0,j=0;
        
        while(true)
        {
            if(j==n-1)
            {
                result=result+convertSingleChar(s.substring(i,j+1));
                return result;
            }
            else if(!s.substring(j,j+1).equals(s.substring(j+1,j+2)))
            {
                result=result+convertSingleChar(s.substring(i,j+1));
                i=j+1;
                j=i;
            }
            else
                j++;
        }

    }
}