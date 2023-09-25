class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        n=len(nums)
        l=n
        r=-1
        
        stack=[]
        
        for i in range(n):
            while stack and nums[i]<nums[stack[-1]]:
                l=min(l,stack.pop())
            stack.append(i)
        
        stack.clear()
        
        for i in range(n-1,-1,-1):
            while stack and nums[i]>nums[stack[-1]]:
                r=max(r,stack.pop())
            stack.append(i)
        
        if l>r:
            return 0
        
        return r-l+1