class Solution:
    def numSquares(self, n: int) -> int:
        P=[float('inf') for i in range(n+1)]
        
        for i in range(n+1):
            if i**2>n:
                break
            
            P[i**2]=1
        
        for i in range(2,n+1):
            if P[i]!=1:
                for j in range(1,i):
                    if P[j]==1:
                        P[i]=min(P[i],1+P[i-j])
        
        #print(P)
        
        return P[n]