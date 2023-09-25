class Solution:
    
    def dp(self,nums,index,count,target,map1):
        key=str(index)+str(count)+str(target)
        if key in map1:
            return map1[key]
        
        ans=False
        
        if count==0:
            return target==0
        
        if index==len(nums):
            return False
        
        if nums[index]<=target:
            ans=self.dp(nums,index+1,count-1,target-nums[index],map1) or self.dp(nums,index+1,count,target,map1)
        else:
            ans=self.dp(nums,index+1,count,target,map1) 
        
        map1[key]=ans
        
        return ans
        
    
    def splitArraySameAverage(self, nums: List[int]) -> bool:
        sum1=sum(nums)
        map1={}
        n=len(nums)

        for count in range(1,n//2+1):
            if (sum1*count)%n==0 and self.dp(nums,0,count,sum1*count/n,map1):
                return True
        
        return False