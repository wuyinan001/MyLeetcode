class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        if(n==0)
            return 0;
        
        
        // P1[i]: Max profit if complete at most one transaction from day 0 to day i
        int[] P1=new int[n];
        // P2[i]: Max profit if complete at most one transaction from day i to day n-1
        int[] P2=new int[n];
        
        P1[0]=0;
        int curmin=prices[0];
        
        for(int i=1;i<n;i++)
        {
            P1[i]=max(P1[i-1],prices[i]-curmin);
            curmin=min(curmin,prices[i]);
            
            //System.out.println("P1-"+i+": "+P1[i]);
        }
        
        P2[n-1]=0;
        int curmax=prices[n-1];
        
        for(int i=n-2;i>=0;i--)
        {
            P2[i]=max(P2[i+1],curmax-prices[i]);
            curmax=max(curmax,prices[i]);
            
            //System.out.println("P2-"+i+": "+P2[i]);
        }
        
        int max=P1[n-1];
        
        for(int i=0;i<n-1;i++)
        {
            int sum=P1[i]+P2[i+1];
            
            if(max<sum)
                max=sum;
        }
        
        return max;
    }
    
    private int max(int p1, int p2)
    {
        if(p1>p2)
            return p1;
        else
            return p2;
    }
    
    private int min(int p1, int p2)
    {
        if(p1<p2)
            return p1;
        else
            return p2;
    }
}