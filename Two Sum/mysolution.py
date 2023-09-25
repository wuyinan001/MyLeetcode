class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        map1={}
        
        for i in range(n):
            if target-nums[i] in map1.keys():
                return [map1[target-nums[i]],i]
            else:
                map1[nums[i]]=i
        
        return [-1,-1]