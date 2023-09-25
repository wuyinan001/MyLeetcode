class Solution {
    public int minCost(int[][] costs) {
        int n=costs.length;
        
        if(n==0)
            return 0;
        
        // L[i][j] contains min acumulative cost ending at costs[i][j]
        int[][] L=new int[n][3];
        
        for(int j=0;j<3;j++)
            L[0][j]=costs[0][j];
        
        for(int i=1;i<n;i++)
        {
            L[i][0]=Math.min(L[i-1][1],L[i-1][2])+costs[i][0];
            L[i][1]=Math.min(L[i-1][2],L[i-1][0])+costs[i][1];
            L[i][2]=Math.min(L[i-1][0],L[i-1][1])+costs[i][2];
        }
        
        return Math.min(L[n-1][0],Math.min(L[n-1][1],L[n-1][2]));
    }
}