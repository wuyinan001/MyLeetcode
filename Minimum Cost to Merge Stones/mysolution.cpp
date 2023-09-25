class Solution {
public:
    int mergeStones(vector<int>& stones, int k) {
        int n=stones.size();
        
        if((n-1)%(k-1)!=0)
            return -1;
        
        vector<int> presum(n+1,0);
        
        for(int i=0;i<n;i++)
        {
            presum[i+1]=presum[i]+stones[i];
        }
        
        vector<vector<int>> dp(n,vector<int>(n,0));
        
        for(int gap=1;gap<n;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                dp[i][j]=INT_MAX;
                for(int m=i;m<j;m+=k-1)
                {
                    dp[i][j]=min(dp[i][j],dp[i][m]+dp[m+1][j]);
                }
                if((j-i)%(k-1)==0)
                    dp[i][j]+=presum[j+1]-presum[i];
            }
        }
        
        return dp[0][n-1]==INT_MAX ? -1 : dp[0][n-1];
    }
};