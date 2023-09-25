class Solution:
    def backTrack(self,nums,index,target,list1,list2):
        if target==0:
            list2.append(list1[:])
            return
        
        if index==len(nums):
            return
        
        i=index
        
        while i<len(nums):
            if nums[i]<=target:
                list1.append(nums[i])
                self.backTrack(nums,i+1,target-nums[i],list1,list2)
                list1.pop()
            
            while i<len(nums)-1 and nums[i]==nums[i+1]:
                i+=1
            
            i+=1
            
            
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans=[]
        self.backTrack(candidates,0,target,[],ans)
        
        return ans