class Solution:
    def numberOfWays(self, s: str) -> int:
        n=len(s)
        ones=0
        
        for c in s:
            if c=='1':
                ones+=1
        
        zeros=n-ones
        
        ans=0
        left_ones=0
        left_zeros=0
        
        for c in s:
            if c=='0':
                ans+=left_ones*(ones-left_ones)
                left_zeros+=1
            else:
                ans+=left_zeros*(zeros-left_zeros)
                left_ones+=1
        
        return ans