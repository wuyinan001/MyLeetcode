class Solution:
    
    def backTrack(self,array,index,target,list1,list2):
        if target==0:
            list2.append(list1[:])
        
        for i in range(index,len(array)):
            if array[i]<=target:
                list1.append(array[i])
                self.backTrack(array,i,target-array[i],list1,list2)
                list1.pop()
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans=[]
        self.backTrack(candidates,0,target,[],ans)
        return ans