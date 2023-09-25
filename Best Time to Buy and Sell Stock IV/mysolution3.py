class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n=len(prices)
        if n<=1 or k==0:
            return 0
        
        # sell[i][j]: the max profit from day 0 to day i with j+1 transactions when the last transaction is sell;
        # buy[i][j]: the max profit from day 0 to day i with j+1 transactions when the last transaction is buy;
        sell=[[-inf for j in range(k)] for i in range(n)]
        buy=[[-inf for j in range(k)] for i in range(n)]
        buy[0][0]=-prices[0]
        for j in range(k):
            for i in range(1,n):
                if j==0:
                    buy[i][j]=max(buy[i-1][j],-prices[i])
                else:
                    buy[i][j]=max(buy[i-1][j],sell[i-1][j-1]-prices[i])
                
                sell[i][j]=max(sell[i-1][j],buy[i-1][j]+prices[i])
        
        ans=0
        for j in range(k):
            ans=max(ans,sell[n-1][j])
        
        return ans