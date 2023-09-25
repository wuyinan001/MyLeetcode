class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result=[]
        
        if not nums:
            return [result]
        
        for i in range(len(nums)):
            
            a=nums[i]
            
            result.extend([a]+x for x in self.permute(nums[0:i]+nums[i+1:]))
        
        return result