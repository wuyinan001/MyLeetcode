class Solution:
    def jump(self, nums: List[int]) -> int:
        n=len(nums)
        curr_step=0
        next_step=0
        ans=0
        
        for i in range(n-1):    
            next_step=max(next_step,i+nums[i])
            
            if i==curr_step:
                ans+=1
                curr_step=next_step
                
        return ans