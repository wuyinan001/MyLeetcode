class Solution {
    
    
    private boolean repeatedSubstringPattern(String s, String sub)
    {   
        int n=s.length(), m=sub.length();
        
        if(m>n)
            return false;
        
        if(s.equals(sub))
            return true;
        
        if(sub.equals(s.substring(0,m))&&repeatedSubstringPattern(s.substring(m),sub))
            return true;
        
        return false;
    }
    
    public boolean repeatedSubstringPattern(String s) {
        
        int n=s.length();
        
        for(int i=0;i<n-1;i++)
        {
            if(repeatedSubstringPattern(s,s.substring(0,i+1)))
                return true;
        }
        
        return false;
    }
}