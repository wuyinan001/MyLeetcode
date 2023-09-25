class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=len(nums)
        prev=nums[0]
        
        i=0
        j=1
        
        while j<n:
            if nums[j]>nums[i]:
                nums[i+1]=nums[j]
                i+=1
                j+=1
            else:
                while j<n and nums[j]==nums[i]:
                    j+=1
                
        
        return i+1