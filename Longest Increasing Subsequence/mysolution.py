class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n=len(nums)
        L=[1 for i in range(n)]
        
        for i in range(1,n):
            for j in range(0,i):
                if nums[j]<nums[i] and L[i]<1+L[j]:
                    L[i]=1+L[j]
        
        return max(L)