class Solution:
    
    def dp(self,stones,index,sumA,sumB,memo):
        if index==len(stones):
            return abs(sumA-sumB)
        
        if memo[index][sumA]!=None:
            return memo[index][sumA]
        
        ans=min(self.dp(stones,index+1,sumA+stones[index],sumB,memo),
                   self.dp(stones,index+1,sumA,sumB+stones[index],memo))
        
        memo[index][sumA]=ans
        
        return ans
    
    def lastStoneWeightII(self, stones: List[int]) -> int:
        n=len(stones)
        sum1=0
        
        for i in stones:
            sum1+=i
        
        memo=[[None for j in range(sum1+1)] for i in range(n)]
        
        return self.dp(stones,0,0,0,memo)