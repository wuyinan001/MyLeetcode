class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        curr=sum(nums[:k])
        maxsum=curr
        n=len(nums)
        for i in range(k,n):
            curr=curr+nums[i]-nums[i-k]
            maxsum=max(maxsum,curr)
        
        return maxsum*1.0/k