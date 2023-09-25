class Solution:
    def backTrack(self,nums,index,target,list1,list2):
        if target==0:
            temp=list1[:]
            if temp not in list2:
                list2.append(temp)
            return
        
        for i in range(index,len(nums)):
            if nums[i]<=target:
                list1.append(nums[i])
                self.backTrack(nums,i+1,target-nums[i],list1,list2)
                list1.pop()
        
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans=[]
        self.backTrack(candidates,0,target,[],ans)
        return ans