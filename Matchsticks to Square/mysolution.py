class Solution:
    def backTrack(self,nums,index,cum,target,k,visited):
        if k==1:
            return True
        
        if cum==target:
            return self.backTrack(nums,0,0,target,k-1,visited)
        
        for i in range(index,len(nums)):
            if nums[i]+cum<=target and not visited[i]:
                visited[i]=True
                if self.backTrack(nums,i+1,cum+nums[i],target,k,visited):
                    return True
                visited[i]=False
        
        return False
        
        
    def makesquare(self, matchsticks: List[int]) -> bool:
        sum1=sum(matchsticks)
        if sum1%4!=0:
            return False
        
        n=len(matchsticks)
        visited=[False for i in range(n)]
        
        return self.backTrack(matchsticks,0,0,int(sum1/4),4,visited)