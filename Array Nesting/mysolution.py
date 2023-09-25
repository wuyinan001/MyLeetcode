class Solution:
    def __init__(self):
        self.visited=set([])
        self.ans=0
    
    # max length starting at u to visit all the non visited nodes
    def dfs(self,u,nums):
        self.visited.add(u)
        v=nums[u]
        if v in self.visited:
            return 1
        else:
            return 1+self.dfs(v,nums)
        
        
    def arrayNesting(self, nums: List[int]) -> int:
        n=len(nums)
        
        for i in range(n):
            if i not in self.visited:
                self.ans=max(self.ans,self.dfs(i,nums))
        
        return self.ans