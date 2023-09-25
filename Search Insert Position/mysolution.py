class Solution:
    def binary(self,nums,lo,hi,target):
        if lo>hi:
            return lo
        
        mid=(lo+hi)//2
        
        if target==nums[mid]:
            return mid
        elif target<nums[mid]:
            return self.binary(nums,lo,mid-1,target)
        else:
            return self.binary(nums,mid+1,hi,target)
    
    def searchInsert(self, nums: List[int], target: int) -> int:
        return self.binary(nums,0,len(nums)-1,target)