class Solution:
    
    def rob2(self,nums,lo,hi):
        if lo==hi:
            return nums[lo]
        elif lo+1==hi:
            return max(nums[lo],nums[hi])
        
        L=[0 for i in range(hi-lo+1)]
        
        L[0]=nums[lo]
        L[1]=max(nums[lo],nums[lo+1])
        
        for i in range(2,hi-lo+1):
            L[i]=max(L[i-1],L[i-2]+nums[lo+i])
        
        return L[hi-lo]
        
    
    def rob(self, nums: List[int]) -> int:
        n=len(nums)
        
        if n==1:
            return nums[0]
        elif n==2:
            return max(nums[0],nums[1])
        
        return max(self.rob2(nums,0,n-2),self.rob2(nums,1,n-1))