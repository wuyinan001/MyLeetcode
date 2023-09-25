class Solution {
    
    private boolean contains(String s, String str)
    {
        if(s.length()<str.length())
            return false;
        
        int n1=s.length(), n2=str.length();
        
        for(int i=n1-n2;i>=0;i--)
            if(s.substring(i,i+n2).equals(str))
                return true;
        
        return false;
    }
    
    public boolean queryString(String s, int n) {
        
        for(int i=1;i<=n;i++)
        {
            String str=Integer.toBinaryString(i);
            if(!contains(s,str))
                return false;
            
        }
        
        return  true;
    }
}