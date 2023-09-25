class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack=[]
        stack.append(-1)
        width=0
        height=0
        ans=0
        n=len(heights)
        for i in range(n):
            while stack[-1]!=-1 and heights[i]<heights[stack[-1]]:
                height=heights[stack.pop()]
                width=i-1-stack[-1]
                ans=max(ans,height*width)
            stack.append(i)
        
        while stack[-1]!=-1:
            height=heights[stack.pop()]
            width=n-1-stack[-1]
            ans=max(ans,height*width)
        
        return ans