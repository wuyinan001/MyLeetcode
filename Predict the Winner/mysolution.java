class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        int n=nums.length;
        
        // T[i][j]: total sum from nums i to j
        int[][] T=new int[n][n];
        
        // L[i][j]: max total sum player can get from nums i to j
        int[][] L=new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            T[i][i]=nums[i];
            L[i][i]=nums[i];
        }
           
        
        for(int s=1;s<=n-1;s++)
        {
            for(int i=0;i<n-s;i++)
            {
                int j=i+s;
                T[i][j]=T[i+1][j]+T[i][j-1]-T[i+1][j-1];
                L[i][j]=Math.max(nums[i]+T[i+1][j]-L[i+1][j],nums[j]+T[i][j-1]-L[i][j-1]);
            }
        }
        
        return L[0][n-1]>=T[0][n-1]-L[0][n-1];
    }

}