class Solution:
    
    def backTrack(self,nums,index,cum,target,k,visited):
        if k==1:
            return True
        
        if cum==target:
            return self.backTrack(nums,0,0,target,k-1,visited)
        
        for i in range(index,len(nums)):
            if not visited[i] and nums[i]+cum<=target:
                visited[i]=True
                if self.backTrack(nums,i+1,cum+nums[i],target,k,visited):
                    return True
                visited[i]=False
        
        return False
        
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        sum1=sum(nums)
        n=len(nums)
        
        if k>n or sum1%k!=0:
            return False
        
        visited=[False for i in range(n)]
        
        return self.backTrack(nums,0,0,sum1/k,k,visited)