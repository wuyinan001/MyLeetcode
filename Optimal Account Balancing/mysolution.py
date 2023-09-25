class Solution:
    
    def backTrack(self,nums,index):
        if index==len(nums):
            return 0
        
        if nums[index]==0:
            return self.backTrack(nums,index+1)
        
        ans=inf
        
        for i in range(index+1,len(nums)):
            if nums[i]*nums[index]<0:
                nums[i]+=nums[index]
                ans=min(ans,1+self.backTrack(nums,index+1))
                nums[i]-=nums[index]
        
        return ans
    
    def minTransfers(self, transactions: List[List[int]]) -> int:
        dict1={}
        
        for t in transactions:
            if t[0] not in dict1:
                dict1[t[0]]=0
            
            if t[1] not in dict1:
                dict1[t[1]]=0
            
            dict1[t[0]]-=t[2]
            dict1[t[1]]+=t[2]
        
        list1=list(dict1.values())
        return self.backTrack(list1,0)