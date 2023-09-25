class Solution {
    
    private boolean isValid(String s)
    {
        int n=s.length();
        
        for(int i=0;i<n/2;i++)
            if(s.charAt(i)!=s.charAt(n-1-i))
                return false;
        
        return true;
    }
    
    public boolean validPalindrome(String s) {
        
        int n=s.length();
        int i=0,j=n-1;
        
        boolean used=false;
        
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                if(!used)
                {
                    i++;
                    used=true;
                }
                else
                {
                    break;
                }
            }
        }
        
        if(i>=j)
            return true;
        
        i=0;
        j=n-1;
        
        used=false;
        
        
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                if(!used)
                {
                    j--;
                    used=true;
                }
                else
                {
                    break;
                }
            }
        }
        
        return i>=j;
    }
}