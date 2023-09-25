class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        
        if n==0:
            return 0
        
        if n==2 or n==1:
            return max(nums)
        
        return max(self.rob1(nums[0:-1]),self.rob1(nums[1:]))
    
    def rob1(self,nums):
        n=len(nums)
        
        if n==0:
            return 0
        
        if n==1:
            return nums[0]
            
        L=[]
        L.append(nums[0])
        L.append(nums[1])
        
        for i in range(2,n):
            L.append(max(L[:i-1])+nums[i])
        
        return max(L)