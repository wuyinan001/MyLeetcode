class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ans=0
        P=0
        
        for i in range(1,len(prices)):
            P=max(0,P+prices[i]-prices[i-1])
            ans=max(ans,P)
        
        return ans