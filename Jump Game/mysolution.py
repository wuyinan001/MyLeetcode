class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n=len(nums)
        i=n-1
        
        while i>0:
            j=i-1
            while j>=0:
                if nums[j]+j>=i:
                    i=j
                    break
                j-=1
                
            if j==-1:
                return False
        
        return True