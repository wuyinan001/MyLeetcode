class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        slow=0
        fast=0
        n=len(nums)

        while fast<n:
            if nums[slow]!=0:
                slow+=1
                fast+=1
            else:
                while fast<n and nums[fast]==0:
                    fast+=1
                if fast<n:
                    t=nums[fast]
                    nums[fast]=0
                    nums[slow]=t
                    slow+=1
                    fast+=1