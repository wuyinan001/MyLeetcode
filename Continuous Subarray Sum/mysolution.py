class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        map1={0:-1}
        
        sum1=0
        
        for i in range(len(nums)):
            sum1=(sum1+nums[i])%k
            
            if sum1 in map1:
                if i-map1[sum1]>=2:
                    return True
            else:
                map1[sum1]=i
        
        return False