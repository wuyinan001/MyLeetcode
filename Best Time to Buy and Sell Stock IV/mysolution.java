class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        
        if(n==0||k==0)
            return 0;
        
        k=(int)(Math.min(Math.ceil(n/2.0),k));
        
        // buy[i][b]: maximum profit within range of day 0 to day i and b transactions last transaction buy
        // sell[i][b]: maximum profit within range of day 0 to day i and b transactions last transaction sell
        int[][] buy=new int[n][k+1];
        int[][] sell=new int[n][k+1];
        
        
        // Set intial values a large negative num so that impossible transactions will not be selected. Impossible transactions mean not possible to do b buys or sells on day i. For example, sell[1,2] is impossible because on day 1 you can do one sell at most
        for(int i=0;i<n;i++)
        {
            for(int b=1;b<=k;b++)
            {
                buy[i][b]=-1000;
                sell[i][b]=-1000;
            }
        }
        
        buy[0][1]=-prices[0];
        
        int max=0;
        
        for(int i=1;i<n;i++)
        {
            for(int b=1;b<=Math.min((int)(Math.ceil((i+1)/2.0)),k);b++)
            {
                buy[i][b]=Math.max(buy[i-1][b],sell[i-1][b-1]-prices[i]);
                
                /*
                if(b<=Math.ceil(i/2.0))
                    buy[i][b]=Math.max(buy[i-1][b],sell[i-1][b-1]-prices[i]);
                else
                    buy[i][b]=sell[i-1][b-1]-prices[i];*/
                
                if(b<=Math.floor((i+1)/2.0))
                {
                    sell[i][b]=Math.max(sell[i-1][b],buy[i-1][b]+prices[i]);
                }
                    
                //System.out.println("sell["+i+","+b+"]: "+sell[i][b]);
                //System.out.println("buy["+i+","+b+"]: "+buy[i][b]);
            }
        }
        
        for(int b=1;b<=Math.min((Math.floor(n/2.0)),k);b++)
        {
            if(max<sell[n-1][b])
                max=sell[n-1][b];
        }
        
        return max;
    }
}