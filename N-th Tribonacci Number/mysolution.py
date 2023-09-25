class Solution:
    def tribonacci(self, n: int) -> int:
        if n==0:
            return 0
        elif n==1:
            return 1
        elif n==2:
            return 1
        
        L=[0 for _ in range(n+1)]
        
        L[0]=0
        L[1]=1
        L[2]=1
        
        for i in range(3,n+1):
            L[i]=L[i-1]+L[i-2]+L[i-3]
        
        return L[n]