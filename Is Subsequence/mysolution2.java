class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length()>t.length())
            return false;
        
        int n=s.length(),m=t.length(),i=0,j=0;
        
        while(j<m)
        {
            if(i==n)
                break;
            
            char c1=s.charAt(i), c2=t.charAt(j);
            
            if(c1==c2)
            {
                i++;
                j++;
            }
            else
                j++;
        }
        
        return i==n;
    }
}