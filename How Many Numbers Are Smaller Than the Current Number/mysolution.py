class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        dict1={}
        
        for i in nums:
            dict1[i]=dict1.get(i,0)+1
        
        n=len(nums)
        
        ans=[0 for _ in range(n)]
        
        for i in range(n):
            for key in dict1:
                if key<nums[i]:
                    ans[i]+=dict1[key]
        
        return ans