class Solution {
    public int minDistance(int[] houses, int k) {
        
        int n=houses.length;
        Arrays.sort(houses);
        
        // dp[i][j]: min total distances when there are i+1 houses and j+1 mailboxes
        int[][] dp=new int[n][k];
        int sum=0, pos=0;
        
        for(int i=1;i<n;i++)
        {
            sum+=houses[i]-houses[pos];
            dp[i][0]=sum;
            // If at even number of houses, i.e., i=1,i=3,i=5,..., move mailbox pos to the next index.
            if(i%2!=0)
                pos++;
        }
        
        for(int j=1;j<k;j++)
        {
            // If num of houses<=num of mailboxes, then min total distance is 0
            for(int i=j+1;i<n;i++)
            {
                // Start by putting the jth mailbox at ith house
                dp[i][j]=dp[i-1][j-1];
                sum=0;
                pos=i;
                
                // In each iteration, assigning mth~ith house to jth mailbox
                for(int m=i-1;m>0;m--)
                {
                    sum+=houses[pos]-houses[m];
                    dp[i][j]=Math.min(dp[i][j],dp[m-1][j-1]+sum);
                    
                    if((i-m+1)%2==0)
                        pos--;
                }
            }
        }
        
        return dp[n-1][k-1];
    }
}