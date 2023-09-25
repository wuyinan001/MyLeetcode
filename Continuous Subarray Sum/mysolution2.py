class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        n=len(nums)
        
        # map1[re] holds the first index of presum array where the remainder of k 
        # is equal to re
        map1={0:-1}
        
        sum1=0
        
        for i in range(n):
            sum1+=nums[i]
            re=sum1%k
            if re in map1 and i>map1[re]+1:
                return True
            
            if re not in map1:
                map1[re]=i
        
        return False