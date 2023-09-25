class Solution {
    public int minCostII(int[][] costs) {
        int n=costs.length;
        
        if(n==0)
            return 0;
        
        int m=costs[0].length;
        
        // L[i][j]: min acumulative cost to paint houses 0 to i using color j to paint the house i
        int[][] L=new int[n][m];
        
        for(int j=0;j<m;j++)
            L[0][j]=costs[0][j];
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int min=L[i-1][(j+1)%m]+costs[i][j];
                
                for(int k=0;k<m;k++)
                {
                    if(k!=j&&L[i-1][k]+costs[i][j]<min)
                        min=L[i-1][k]+costs[i][j];
                }
                
                L[i][j]=min;
            }
        }
        
        int result=L[n-1][0];
        
        for(int j=1;j<m;j++)
        {
            if(L[n-1][j]<result)
                result=L[n-1][j];
        }
        
        return result;
    }
}