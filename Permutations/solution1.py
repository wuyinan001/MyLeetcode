class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result=[]
        
        if not nums:
            return result
        
        for i in range(len(nums)):
            
            sub_nums=nums[:]
            sub_nums.remove(nums[i])
            
            #print(sub_nums)
            
            sub_result=self.permute(sub_nums)
            
            #print(sub_result)
            if len(sub_result)==0:
                result.append([nums[i]])
            else:
                for j in range(len(sub_result)):
                    result.append([nums[i]]+sub_result[j])
        
        return result