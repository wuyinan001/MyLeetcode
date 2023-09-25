class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        copy=nums[:]
        copy.sort()
        left=0
        right=len(nums)-1
        n=len(nums)
        
        while left<n:
            if nums[left]!=copy[left]:
                break
            left+=1
        
        while right>=0:
            if nums[right]!=copy[right]:
                break
            right-=1
        
        return max(right-left+1,0)