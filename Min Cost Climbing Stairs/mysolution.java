class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        
        if(n==0)
            return 0;
        
        if(n==1)
            return cost[0];
        
        // L[i] counts min cost of getting at index i step
        int[] L=new int[n];
        
        L[0]=cost[0];
        L[1]=cost[1];
        
        for(int i=2;i<n;i++)
        {
            if(L[i-2]<L[i-1])
                L[i]=cost[i]+L[i-2];
            else
                L[i]=cost[i]+L[i-1];
        }
        
        if(L[n-1]<L[n-2])
            return L[n-1];
        else
            return L[n-2];
    }
}