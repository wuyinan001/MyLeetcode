class Solution:
    def canJump(self, nums: List[int]) -> bool:
        curr_bound=0
        next_bound=0
        n=len(nums)
        
        for i in range(n):
            if i>curr_bound:
                if next_bound==curr_bound:
                    return False
                else:
                    curr_bound=next_bound
            next_bound=max(next_bound,i+nums[i])
        
        return True