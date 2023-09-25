class Solution:
    def binarySearch(self,nums,lo,hi):
        if lo>=hi:
            return nums[lo]
        
        if nums[lo]<nums[hi]:
            return nums[lo]
        
        mid=(lo+hi)//2
        
        left=self.binarySearch(nums,lo,mid)
        right=self.binarySearch(nums,mid+1,hi)
        
        return min(left,right)
    
    def findMin(self, nums: List[int]) -> int:
        return self.binarySearch(nums,0,len(nums)-1)