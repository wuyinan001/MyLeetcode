class Solution {
    
    private int dp(int[] arr, int i, int j, Integer[][] memo)
    {
        if(memo[i][j]!=null)
            return memo[i][j];
        
        int ans=Integer.MAX_VALUE;
        
        if(arr[i]==arr[j])
            ans=dp(arr,i+1,j-1,memo);
        
        for(int k=i;k<j;k++)
        {
            ans=Math.min(ans,dp(arr,i,k,memo)+dp(arr,k+1,j,memo));
        }
        
        memo[i][j]=ans;
        
        return ans;
    }
    
    public int minimumMoves(int[] arr) {
     
        int n=arr.length;
        
        if(n==1)
            return 1;
        
        Integer[][] memo=new Integer[n][n];
        
        for(int i=0;i<n;i++)
            memo[i][i]=1;
        
        for(int i=0;i<n-1;i++)
            if(arr[i]==arr[i+1])
                memo[i][i+1]=1;
            else
                memo[i][i+1]=2;
        
        return dp(arr,0,n-1,memo);
    }
}