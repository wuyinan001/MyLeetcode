class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq=[]
        n=len(nums)
        ans=[]
        
        for i in range(n):
            while dq and nums[i]>nums[dq[-1]]:
                dq.pop()
            
            if dq and dq[0]<=i-k:
                dq.pop(0)
            
            dq.append(i)
            if i>=k-1:
                ans.append(nums[dq[0]])
        
        return ans