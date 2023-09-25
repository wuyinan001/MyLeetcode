import numpy as np

class Solution:
    
    def dp(self,nums,index,k,memo):
        if index==len(nums):
            return 0
        
        if k<0:
            return inf
        
        if memo[index][k]!=None:
            return memo[index][k]
        
        ans=inf
        max1=0
        wasted=0
        sum1=0
        
        for i in range(index,len(nums)):
            max1=max(max1,nums[i])
            sum1+=nums[i]
            wasted=max1*(i-index+1)-sum1
            ans=min(ans,wasted+self.dp(nums,i+1,k-1,memo))
        
        memo[index][k]=ans
        return ans
    
    def minSpaceWastedKResizing(self, nums: List[int], k: int) -> int:
        n=len(nums)
        memo=np.full((n,k+1),None)
        
        if k>=n-1:
            return 0
        
        return self.dp(nums,0,k,memo)