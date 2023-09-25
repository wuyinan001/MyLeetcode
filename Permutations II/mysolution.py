class Solution:
    def backTrack(self,nums,list1,list2,visited):
        if len(list1)==len(nums):
            list2.append(list1[:])
            return
        
        for i in range(len(nums)):
            # if nums[i] has duplicates and nums[i] is not the first
            # then do not put nums[i] as the first element of this values in the list
            if i>0 and nums[i]==nums[i-1] and (i-1) not in visited:
                continue
            
            if i not in visited:
                list1.append(nums[i])
                visited.add(i)
                self.backTrack(nums,list1,list2,visited)
                list1.pop()
                visited.remove(i)
        
        
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        visited=set([])
        
        ans=[]
        
        self.backTrack(nums,[],ans,visited)
        
        return ans