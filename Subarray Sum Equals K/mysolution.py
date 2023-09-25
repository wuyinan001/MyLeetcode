class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dict1={0:1}
        sum1=0
        ans=0
        
        for i in nums:
            sum1+=i
            if sum1-k in dict1:
                ans+=dict1[sum1-k]
            
            dict1[sum1]=dict1.get(sum1,0)+1
        
        return ans