class Solution {
    public int titleToNumber(String s) {
        
        int n=s.length();
        
        if(n==0)
            return 0;
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            ans=ans+s.charAt(i)-'A'+1;
            
            if(i!=n-1)
                ans=ans*26;
        }
        
        return ans;
    }
}