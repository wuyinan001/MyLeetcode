class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums)==1:
            return nums[0]
        elif len(nums)==2:
            return max(nums[0],nums[1])
        
        n=len(nums)
        
        dp=[]
        dp.append(nums[0])
        dp.append(nums[1])
        
        for i in range(2,n):
            dp.append(nums[i])
            m=0
            for j in range(i-1):
                m=max(m,dp[j])
            dp[i]+=m
            
        for i in dp:
            m=max(m,i)
            
        return m