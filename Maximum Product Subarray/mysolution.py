class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n=len(nums)
        minP=[0 for i in range(n)]
        maxP=[0 for i in range(n)]
        
        minP[0]=nums[0]
        maxP[0]=nums[0]
        
        for i in range(1,n):
            if nums[i]>=0:
                maxP[i]=max(nums[i],nums[i]*maxP[i-1])
                minP[i]=min(nums[i],nums[i]*minP[i-1])
            else:
                maxP[i]=max(nums[i],nums[i]*minP[i-1])
                minP[i]=min(nums[i],nums[i]*maxP[i-1])
        
        max_val=maxP[0]
        
        for i in range(1,n):
            max_val=max(max_val,maxP[i])
        
        return max_val