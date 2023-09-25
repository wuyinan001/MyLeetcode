class Solution:
    def trap(self, height: List[int]) -> int:
        n=len(height)
        left=[height[0] for _ in range(n)]
        right=[height[-1] for _ in range(n)]
        
        for i in range(1,n):
            left[i]=max(left[i-1],height[i])
        
        for i in range(n-2,-1,-1):
            right[i]=max(right[i+1],height[i])
        
        ans=0
        
        for i in range(n):
            ans+=min(left[i],right[i])-height[i]
        
        return ans