class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n=len(nums)
        sum1=0
        
        for i in nums:
            sum1+=i
        
        return (int)(n*(1+n)/2)-sum1