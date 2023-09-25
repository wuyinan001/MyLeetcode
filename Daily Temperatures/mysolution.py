class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n=len(temperatures)
        ans=[0 for i in range(n)]
        stack=[]
        
        stack.append(n-1)
        
        for i in range(n-2,-1,-1):
            while stack and temperatures[stack[-1]]<=temperatures[i]:
                stack.pop()
            
            if stack:
                ans[i]=stack[-1]-i
            
            stack.append(i)
        
        return ans