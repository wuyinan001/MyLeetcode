class Solution:
    
    def binary(self,nums,lo,hi,target):
        while lo<=hi:
            mid=(lo+hi)//2
            if target==nums[mid]:
                return mid
            elif target<nums[mid]:
                hi=mid-1
            else:
                lo=mid+1
        
        return -1
    
    def search(self, nums: List[int], target: int) -> int:
        min_index=-1
        n=len(nums)
        lo=0
        hi=n-1
        
        if nums[lo]<=nums[hi]:
            min_index=lo
        else:
            mid=(lo+hi)//2
            while lo+1<hi:
                if nums[lo]<nums[mid]:
                    lo=mid
                else:
                    hi=mid
                mid=(lo+hi)//2
            if lo==hi:
                min_index=lo
            else:
                min_index=lo if nums[lo]<nums[hi] else hi
        
        ans=self.binary(nums,min_index,n-1,target)
        
        if ans==-1:
            return self.binary(nums,0,min_index-1,target)
        else:
            return ans