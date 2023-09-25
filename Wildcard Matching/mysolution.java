class Solution {
    
    int n1,n2;
    
    public boolean isMatch(String s, String p) {
        
        if(p.isEmpty())
            return s.isEmpty();
        
        n1=s.length();
        n2=p.length();
        
        int[][] memo=new int[n1+1][n2+1];
        
        memo[n1][n2]=1;
        
        return dp(s,p,0,0,memo);
    }
    
    private boolean dp(String s, String p, int i, int j, int[][] memo)
    {
        if(i==n1)
        {
            if(j==n2)
                return true;
            else if(p.charAt(j)=='*')
                return dp(s,p,i,j+1,memo);
            else
                return false;
        }
        
        if(memo[i][j]!=0)
            return memo[i][j]==1;
        
        int ans=0;
        
        if(j<n2&&p.charAt(j)=='*')
        {
            // If p[j]=='*', we can choose p[j] to match s[i] only; or we can choose p[j] to match s[j] and chars after;
            // Or we can choose p[j] not to match any char
            if(dp(s,p,i+1,j,memo)||dp(s,p,i+1,j+1,memo)||dp(s,p,i,j+1,memo))
                ans=1;
            else
                ans=-1;
        }
        else
        {
            if((i<n1&&j<n2)&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')&&dp(s,p,i+1,j+1,memo))
                ans=1;
            else
                ans=-1;
        }
        
        memo[i][j]=ans;
        
        return ans==1;
    }
    
}