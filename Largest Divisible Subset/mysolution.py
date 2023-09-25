class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        n=len(nums)
        nums.sort()
        subsets={-1:set([])}
        
        for i in range(n):
            subsets[nums[i]]=max([subsets[k] for k in subsets if nums[i]%k==0],key=len)|{nums[i]}
        
        return max([subsets[k] for k in subsets],key=len)