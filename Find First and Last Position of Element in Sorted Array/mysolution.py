class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        if n==0:
            return [-1,-1]
        
        lo=0
        hi=n-1
        
        while lo<hi:
            mid=(lo+hi)//2
            if target>nums[mid]:
                lo=mid+1
            else:
                hi=mid
        
        if nums[lo]!=target:
            return [-1,-1]
        
        start=lo
        
        lo=0
        hi=n-1
        while lo<hi:
            mid=(lo+hi)//2+1
            if target<nums[mid]:
                hi=mid-1
            else:
                lo=mid
        
        end=lo
        
        return [start,end]