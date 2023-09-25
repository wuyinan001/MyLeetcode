class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        left=0
        right=0
        ans=0

        for c in s:
            if c=='(':
                left+=1
            elif c==')':
                right+=1
            
            if right>left:
                ans+=1
                left+=1
        
        ans+=(left-right)

        return ans