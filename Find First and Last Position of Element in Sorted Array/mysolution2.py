class Solution:
    def __init__(self):
        self.left=-1
        self.right=-1
        
    def leftBound(self,nums,lo,hi,target):
        if lo>hi:
            return
        
        mid=(lo+hi)//2
        
        if target==nums[mid]:
            self.left=mid
            self.leftBound(nums,lo,mid-1,target)
        elif target<nums[mid]:
            self.leftBound(nums,lo,mid-1,target)
        else:
            self.leftBound(nums,mid+1,hi,target)
    
    def rightBound(self,nums,lo,hi,target):
        if lo>hi:
            return
        
        mid=(lo+hi)//2
        
        if target==nums[mid]:
            self.right=mid
            self.rightBound(nums,mid+1,hi,target)
        elif target<nums[mid]:
            self.rightBound(nums,lo,mid-1,target)
        else:
            self.rightBound(nums,mid+1,hi,target)
        
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        self.leftBound(nums,0,n-1,target)
        self.rightBound(nums,0,n-1,target)
        
        return [self.left,self.right]