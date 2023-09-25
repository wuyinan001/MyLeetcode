class Solution:
    def findLargestRect(self,heights):
        stack=[-1]
        height=0
        width=0
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
        
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        n=len(matrix)
        if n==0:
            return 0
        m=len(matrix[0])
        heights=[0 for j in range(m)]
        
        ans=0
        
        for i in range(n):
            for j in range(m):
                if matrix[i][j]=="0":
                    heights[j]=0
                else:
                    heights[j]=heights[j]+1
            
            ans=max(ans,self.findLargestRect(heights))
        
        return ans