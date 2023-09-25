class Solution:
    def climbStairs(self, n: int) -> int:
        if n==1:
            return 1
        elif n==2:
            return 2
        
        L=[]
        L.append(1)
        L.append(2)
        
        for i in range(2,n):
            L.append(L[-1]+L[-2])
        
        return L[n-1]