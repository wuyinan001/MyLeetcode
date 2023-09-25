class Solution:
    def numberOfWays(self, s: str) -> int:
        n=len(s)
        
        zeros=0
        
        for c in s:
            if c=='0':
                zeros+=1
        
        ones=n-zeros
        
        ans=0
        
        zeros_left=0
        ones_left=0
        
        if s[0]=='0':
            zeros_left+=1
        else:
            ones_left+=1
        
        for i in range(1,n-1):
            if s[i]=='0':
                ans+=ones_left*(ones-ones_left)
                zeros_left+=1
            else:
                ans+=zeros_left*(zeros-zeros_left)
                ones_left+=1
        
        return ans