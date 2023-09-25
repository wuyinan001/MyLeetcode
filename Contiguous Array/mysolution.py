class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        map1={0:-1}
        sum1=0
        ans=0
        
        for i in range(len(nums)):
            if nums[i]==0:
                sum1+=1
            else:
                sum1+=-1
            
            if sum1 in map1:
                ans=max(ans,i-map1[sum1])
            else:
                map1[sum1]=i
        
        return ans