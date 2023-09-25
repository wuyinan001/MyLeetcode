from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        
        ans=[]
        deq=deque()
        n=len(nums)
        
        for i in range(n):
            while deq and nums[deq[-1]]<nums[i]:
                deq.pop()
            
            if deq and deq[0]<=i-k:
                deq.popleft()
                
            deq.append(i)
            
            if i>=k-1:
                ans.append(nums[deq[0]])
        
        return ans