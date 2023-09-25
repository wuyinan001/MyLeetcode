class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        int n=mat1.length, m=mat1[0].length, l=mat2[0].length;
        
        int[][] ans=new int[n][l];
        
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<l;k++)
            {
                int sum=0;
                for(int j=0;j<m;j++)
                {
                    sum+=mat1[i][j]*mat2[j][k];
                }
                
                ans[i][k]=sum;
            }
        }
        
        return ans;
    }
}