class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        // L[i][j] contains product from index i to index j
        int[][] L=new int[n][n];
        int max=nums[0];
        
        for(int i=0;i<n;i++)
        {
            L[i][i]=nums[i];
            
            if(max<L[i][i])
                max=L[i][i];
        }
        
    
        for(int gap=1;gap<n;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                
                L[i][j]=L[i][j-1]*nums[j];
                
                if(max<L[i][j])
                    max=L[i][j];
            }
        }
        
        return max;
            
    }
}