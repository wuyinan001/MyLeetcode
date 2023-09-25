class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        P=[]
        P.append(0)
        
        for i in range(1,len(prices)):
            P.append(max(0,P[-1]+prices[i]-prices[i-1]))
        
        ans=-inf
        
        for p in P:
            ans=max(ans,p)
            
        return ans