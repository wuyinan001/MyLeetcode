class Solution {
    
    int n1, n2;
    
    public boolean isMatch(String s, String p) {
        
        if(p.isEmpty())
            return  s.isEmpty();
        
        n1=s.length();
        n2=p.length();
        
        // memo[i][j]: 1 if s[i...] matches p[j...]; -1 if s[i...] doesn't match p[j...]; 0 not sure
        int[][] memo=new int[n1+1][n2+1]; 
        memo[n1][n2]=1;
        
        return dp(s,p,0,0,memo);
    }
    
    // whether s[i...] matches p[j...]
    private boolean dp(String s, String p, int i, int j, int[][] memo)
    {
        if(memo[i][j]!=0)
            return memo[i][j]==1;
        
        boolean firstMatch=(i<n1&&j<n2)&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.');
        
        int ans;
        
        if(j+1<n2&&p.charAt(j+1)=='*')
        {
            if(firstMatch&&dp(s,p,i+1,j,memo)||dp(s,p,i,j+2,memo))
                ans=1;
            else
                ans=-1;
        }
        else
        {
            if(firstMatch&&dp(s,p,i+1,j+1,memo))
                ans=1;
            else
                ans=-1;
        }
        
        memo[i][j]=ans;
        return ans==1;
    }
    
}