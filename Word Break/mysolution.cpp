class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n=s.size();
        
        vector<bool> dp(n+1,false);
        
        dp[0]=true;
        
        int maxLen=0;
        
        for(auto word:wordDict)
        {
            maxLen=max(maxLen,int(word.size()));
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j]&&find(wordDict.begin(),wordDict.end(),s.substr(j,i-j))!=wordDict.end())
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        
        // for(auto i:dp)
        //     cout<<i<<" ";
        
        cout<<endl;
        
        return dp[n];
    }
};