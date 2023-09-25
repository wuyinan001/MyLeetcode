class Solution:
    
    def dp(self,nums,index,target,memo):
        if target==0:
            return True
        
        if index==len(nums):
            return False
        
        if memo[index][target]!=None:
            return memo[index][target]
        
        ans=False
        
        if nums[index]<=target:
            ans=self.dp(nums,index+1,target-nums[index],memo) or self.dp(nums,index+1,target,memo)
        else:
            ans=self.dp(nums,index+1,target,memo)
        
        memo[index][target]=ans
        return ans
    
    def canPartition(self, nums: List[int]) -> bool:
        sum1=sum(nums)
        if sum1%2!=0:
            return False
        
        memo=[[None for j in range(int(sum1/2)+1)] for i in range(len(nums))]
        
        return self.dp(nums,0,int(sum1/2),memo)