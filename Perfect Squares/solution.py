class Solution:
    def numSquares(self, n: int) -> int:
        P=[float('inf') for i in range(n+1)]
        P[0]=0
        squared=[i**2 for i in range(1,int(math.sqrt(n))+1)]
        
        for i in range(1,n+1):
            for j in squared:
                if j>i:
                    break
                    
                P[i]=min(P[i],1+P[i-j])
        
        #print(P)
        
        return P[n]