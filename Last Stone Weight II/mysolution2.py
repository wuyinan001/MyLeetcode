class Solution:
    def dp(self,stones,index,sumA,sumB,memo):
        if index==len(stones):
            return abs(sumA-sumB)
        
        if memo[sumA]!=None:
            return memo[sumA]
        
        ans=float('inf')
        
        ans=min(self.dp(stones,index+1,sumA+stones[index],sumB,memo),\
                self.dp(stones,index+1,sumA,sumB+stones[index],memo))
        
        memo[sumA]=ans
        return ans
    
    def lastStoneWeightII(self, stones: List[int]) -> int:
        sum1=sum(stones)
        memo=[None for _ in range(1+sum1)]
        
        return self.dp(stones,0,0,0,memo)