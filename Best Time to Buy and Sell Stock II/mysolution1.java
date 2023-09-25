class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        if(n==1||n==0)
            return 0;
        
        int profit=0;
        
        // when buy==true, buy is allowable and sell is not allowable
        // when buy==false, buy is not allowable and sell is allowable
        boolean buy=true;
        
        for(int i=0;i<n-1;i++)
        {
            if(buy&&prices[i+1]>prices[i])
            {   
                profit=profit-prices[i];
                buy=false;
            }
            
            if(!buy&&prices[i+1]<prices[i])
            {   
                profit=profit+prices[i];
                buy=true;
            }
        }
        
        if(!buy)
            profit=profit+prices[n-1];
        
        return profit;
    }
}