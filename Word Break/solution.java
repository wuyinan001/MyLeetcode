class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n=s.length();
        
        if(n==0)
            return true;
        
        // dp[i]: whether the s.substring(0,i) (not including i) is breakable
        boolean[] dp=new boolean[n+1];
        
        // "" is breakable
        dp[0]=true;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j]&&wordDict.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}