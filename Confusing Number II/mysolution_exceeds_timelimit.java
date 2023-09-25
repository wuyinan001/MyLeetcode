class Solution {
    
    private boolean confusingNumber(int n, int N)
    {
        if(n==0)
            return false;
        
        int sum=0, n_copy=n;
        
        while(n>0)
        {
            int k=n%10;
            
            if(k!=0&&k!=1&&k!=6&&k!=8&&k!=9)
                return false;
            
            if(k==6)
                k=9;
            else if(k==9)
                k=6;
            
            sum=sum*10+k;
            
            n=n/10;
        }
        
        return n_copy!=sum;
    }
    
    public int confusingNumberII(int N) {
        
        int ans=0;
       
        for(int i=0;i<=N;i++)
        {
            if(confusingNumber(i,N))
            {
                ans++;
            }
        }
            
        return ans;
    }
}