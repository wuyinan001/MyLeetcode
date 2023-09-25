class Solution:
    
    def backTrack(self,nums,list1,list2):
        if len(list1)==len(nums):
            list2.append(list1[:])
            return
        
        for i in range(len(nums)):
            if nums[i] not in list1:
                list1.append(nums[i])
                self.backTrack(nums,list1,list2)
                list1.pop()
    
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans=[]
        self.backTrack(nums,[],ans)
        return ans