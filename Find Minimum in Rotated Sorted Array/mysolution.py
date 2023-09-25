class Solution:
    def findMin(self, nums: List[int]) -> int:
        n=len(nums)
        lo=0
        hi=n-1
        
        if nums[lo]<=nums[hi]:
            return nums[lo]
        
        while lo+1<hi:
            mid=(lo+hi)//2
            if nums[lo]<nums[mid]:
                lo=mid
            else:
                hi=mid
        
        return min(nums[lo],nums[hi])