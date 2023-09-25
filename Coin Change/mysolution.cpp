class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1,99999);
        dp[0]=0;
        sort(coins.begin(),coins.end());
        
        for(int i=1;i<=amount;i++)
        {
            for(auto j:coins)
            {
                if(j<=i)
                    dp[i]=min(dp[i],1+dp[i-j]);
                else
                    break;
            }
        }
        
        return dp[amount]>=99999 ? -1 : dp[amount];
    }
};