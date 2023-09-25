class Solution {
public:
    int distinctSubseqII(string s) {
        int n=s.size();
        int mod=1e9+7;
        vector<int> dp(n+1,0);
        
        dp[0]=1;
        map<char,int> map;
        
        for(int i=1;i<=n;i++)
        {
            char c=s[i-1];
            dp[i]=(dp[i-1]*2)%mod;
            
            if(map.find(c)!=map.end())
            {
                dp[i]-=dp[map[c]-1];
            }
            
            if(dp[i]<=0)
                dp[i]+=mod;
            
            map[c]=i;
        }
        
        return dp[n]-1;
    }
};