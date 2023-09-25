class Solution:
    def backTrack(self,nums,index,length,list1,list2):
        if len(list1)==length:
            list2.append(list1[:])
            return
        
        for i in range(index,len(nums)):
            list1.append(nums[i])
            self.backTrack(nums,i+1,length,list1,list2)
            list1.pop()
            
        
        
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n=len(nums)
        ans=[]
        
        for length in range(n+1):
            self.backTrack(nums,0,length,[],ans)
        
        return ans