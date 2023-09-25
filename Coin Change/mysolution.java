class Solution {
    public int coinChange(int[] coins, int amount) {
        // N[a] is min number of coins to get amount a
        // Initialization: N[0]=0, N[a!=0]=inf
        int[] N=new int[amount+1];
        
        for(int i=1;i<=amount;i++)
            N[i]=Integer.MAX_VALUE-10;
        
        int n=coins.length;
        
        for(int a=1;a<=amount;a++)
        {
            for(int i=0;i<n;i++)
            {
                if(coins[i]<=a&&N[a]>N[a-coins[i]]+1)
                    N[a]=N[a-coins[i]]+1;
            }
        }
        
        if(N[amount]==Integer.MAX_VALUE-10)
            return -1;
        
        return N[amount];
    }
}