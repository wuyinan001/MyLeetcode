class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        
        int n=nums.length;
        
        int sum=0;
        
        for(int i=0;i<n;i++)
            sum=sum+nums[i];
        
        if(S>sum||S<-sum)
            return 0;
        
        // N[i][j] is num of combinations at range nums[0] to nums[i] sum to (j-sum)
        // N[i][j]=N[i-1][j-nums[i]]+N[i-1][j+nums[i]] (if j-nums[i]<0 or j+nums[i]>2*sum
        // ignore the index out of boundary term)
        
        int[][] N=new int[n][2*sum+1];
        
        // N[0][j]=0 if nums[0]!=j; 1 if nums[0]==j;
        for(int j=0;j<2*sum+1;j++)
        {
            if(nums[0]==j-sum)
                N[0][j]=1+N[0][j];
            if(nums[0]==sum-j)
                N[0][j]=1+N[0][j];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<2*sum+1;j++)
            {
                if((j-nums[i]>=0)&&(j+nums[i]<=2*sum))
                    N[i][j]=N[i-1][j-nums[i]]+N[i-1][j+nums[i]];
                else if((j-nums[i]>=0)&&(j+nums[i]>2*sum))
                    N[i][j]=N[i-1][j-nums[i]];
                else if((j-nums[i]<0)&&(j+nums[i]<=2*sum))
                    N[i][j]=N[i-1][j+nums[i]];
                else
                    N[i][j]=0;
            }
        }
        
        /*
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2*sum+1;j++)
            {
                System.out.print(N[i][j]+"\t");
            }
            System.out.println();
        }*/
        
        return N[n-1][S+sum];
    }
}