class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[inf for i in range(amount+1)]
        dp[0]=0
        
        for i in range(1,amount+1):
            for j in coins:
                if j<=i and dp[i]>1+dp[i-j]:
                    dp[i]=1+dp[i-j]
        
        return dp[amount] if dp[amount]!=inf else -1