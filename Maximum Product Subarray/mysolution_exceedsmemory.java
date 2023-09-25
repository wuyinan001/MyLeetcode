class Solution {
    public int maxProduct(int[] nums) {
        
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        // L[i][j]: product from nums[i] to nums[j]
        int[][] L=new int[n][n];
        
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            L[i][i]=nums[i];
            if(max<L[i][i])
                max=L[i][i];
        }
        
        
        for(int s=1;s<=n-1;s++)
        {
            for(int i=0;i<=n-1-s;i++)
            {
                int j=i+s;
                L[i][j]=L[i][j-1]*nums[j];
                if(max<L[i][j])
                    max=L[i][j];
            }
        }
        
        return max;
    }
}