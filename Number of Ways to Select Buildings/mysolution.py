class Solution:
    def numberOfWays(self, s: str) -> int:
        n=len(s)
        
        # num of 0 from 0 to i
        count0=[0 for i in range(n)]
        # num of 1 from 0 to i
        count1=[0 for i in range(n)]
        
        # total num of 0
        num_zeros=0
        # total num of 1
        num_ones=0
        
        for i in range(n):
            if s[i]=='0':
                num_zeros+=1
            else:
                num_ones+=1
            
            count0[i]=num_zeros
            count1[i]=num_ones
        
        ans=0
        
        for i in range(1,n-1):
            if s[i]=='0':
                ans+=count1[i-1]*(num_ones-count1[i-1])
            else:
                ans+=count0[i-1]*(num_zeros-count0[i-1])
        
        return ans