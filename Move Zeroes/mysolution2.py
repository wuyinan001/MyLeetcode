class Solution:
    def swap(self,nums,i,j):
        t=nums[i]
        nums[i]=nums[j]
        nums[j]=t
        
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        i=0
        j=0
        
        while j<n:
            if nums[j]==0:
                while i<n and nums[i]==0:
                    i+=1
                if i<n:
                    self.swap(nums,i,j)
            
            i+=1
            j+=1