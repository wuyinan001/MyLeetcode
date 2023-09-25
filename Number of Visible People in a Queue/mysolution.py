class Solution:
    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        stack=[]
        ans=[]
        n=len(heights)
        
        stack.append(heights[n-1])
        ans.append(0)
        
        for i in range(n-2,-1,-1):
            num=0
            while stack and heights[i]>stack[-1]:
                stack.pop()
                num+=1
            
            if stack:
                num+=1
                
            ans.append(num)
            stack.append(heights[i])
        
        ans.reverse()
        return ans