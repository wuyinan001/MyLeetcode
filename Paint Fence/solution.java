class Solution {
    public int numWays(int n, int k) {
        if(n==0||k==0)
            return 0;
        
        int[] ans=new int[n+1];
        
        ans[1]=k;
        
        // same represents number of ways when the last two colors are the same
        // diff represents number of ways when the last two colors are different
        int same=0;
        int diff=k;
        
        for(int i=2;i<=n;i++)
        {
            same=diff;
            diff=ans[i-1]*(k-1);
            ans[i]=same+diff;
        }
        
        return ans[n];
    }
}