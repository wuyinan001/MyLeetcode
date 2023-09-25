class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum1=nums[0]
        maxSum=sum1
        n=len(nums)
        
        for i in range(1,n):
            if sum1>=0:
                sum1+=nums[i]
            else:
                sum1=nums[i]
            
            maxSum=max(maxSum,sum1)
        
        return maxSum