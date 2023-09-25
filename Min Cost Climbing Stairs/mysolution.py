class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n=len(cost)
        
        if n==2:
            return min(cost)
    
        L=[float('inf') for i in range(n)]
        
        L[0]=cost[0]
        L[1]=cost[1]
        
        for i in range(2,n):
            L[i]=min(L[i-1],L[i-2])+cost[i]
        
        return min(L[n-1],L[n-2])