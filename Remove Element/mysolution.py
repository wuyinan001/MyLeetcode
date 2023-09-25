class Solution:
    def swap(self,nums,i,j):
        t=nums[i]
        nums[i]=nums[j]
        nums[j]=t
        
    def removeElement(self, nums: List[int], val: int) -> int:
        n=len(nums)
        i=0
        j=n-1
        
        while True:
            while i<n and nums[i]!=val:
                i+=1
                
            while j>=0 and nums[j]==val:
                j-=1
                
            if i>=j:
                break
                
            self.swap(nums,i,j)
            i+=1
            j-=1
        
        return j+1