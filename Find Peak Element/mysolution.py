class Solution:    
    def binary(self,nums,lo,hi):
        if lo>hi:
            return -1
        
        mid=(lo+hi)//2
        
        left=self.binary(nums,lo,mid-1)
        
        if left!=-1:
            return left
        
        right=self.binary(nums,mid+1,hi)
        
        if right!=-1:
            return right
        
        if mid>0 and mid<len(nums)-1 and nums[mid-1]<nums[mid] and nums[mid]>nums[mid+1]:
            return mid
        
        return -1
            
    
    def findPeakElement(self, nums: List[int]) -> int:
        nums.append(-float('inf'))
        nums.insert(0,-float('inf'))
        
        return self.binary(nums,0,len(nums)-1)-1