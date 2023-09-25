class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n=nums.length;
        
        int[][] L=new int[n][n];
        
        for(int i=0;i<n;i++)
            L[i][i]=nums[i];
        
        for(int i=0;i<n-1;i++)
        {
            for(int s=1;s<n-i;s++)
            {
                int j=i+s;
                L[i][j]=L[i][j-1]*nums[j];
            }
        }
        
        int[] ans=new int[n];
        
        ans[0]=L[1][n-1];
        ans[n-1]=L[0][n-2];
        
        for(int i=1;i<n-1;i++)
        {
            ans[i]=L[0][i-1]*L[i+1][n-1];
        }
        
        return ans;
    }
}