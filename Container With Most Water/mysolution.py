class Solution:
    def maxArea(self, height: List[int]) -> int:
        n=len(height)
        ans=0
        i=0
        j=n-1
        while i<j:
            ans=max(ans,min(height[i],height[j])*(j-i))
            if height[i]<=height[j]:
                i+=1
            else:
                j-=1
        
        return ans