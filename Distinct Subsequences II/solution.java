class Solution {
    public int distinctSubseqII(String s) {
        
        final int mod=(int)(1e9+7);
        
        int n=s.length();
        // dp[i]: the num of distinct subsequences from index 0 to index i-1 (including "")
        int[] dp=new int[n+1];
        
        //last[i]: the index of the most recent character i+'a'
        //Here the first char is index 1, the second char is index 2, ...
        int[] last=new int[26];
        
        for(int i=0;i<26;i++)
            last[i]=-1;
        
        // dp[0]: ""
        dp[0]=1;
        
        for(int i=1;i<=n;i++)
        {
            int c=s.charAt(i-1)-'a';
            
            dp[i]=2*dp[i-1]%mod;
            
            if(last[c]!=-1)
                dp[i]=(dp[i]-dp[last[c]-1])%mod;
            
            last[c]=i;
        }
        
        dp[n]--;
        
        if(dp[n]<0)
            dp[n]+=mod;
        
        return dp[n];
    }
}