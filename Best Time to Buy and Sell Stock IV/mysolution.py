import numpy as np

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n=len(prices)
        
        if n<=1 or k<1:
            return 0
        
        sell=np.full((n,k),-9999,dtype=np.int)
        buy=np.full((n,k),-9999,dtype=np.int)
        
        buy[0,0]=-prices[0]
        
        for i in range(1,n):
            for j in range(k):
                if j==0:
                    buy[i,j]=max(-prices[i],buy[i-1,j])
                else:
                    buy[i,j]=max(sell[i-1,j-1]-prices[i],buy[i-1,j])
                
                sell[i,j]=max(buy[i-1,j]+prices[i],sell[i-1,j])
        
        m=0
        
        for i in sell[n-1,:]:
            m=max(m,i)
        
        return m