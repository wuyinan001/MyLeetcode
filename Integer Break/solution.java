class Solution {
    public int integerBreak(int n) {
        
        int[] P=new int[n+1];
        
        P[1]=1;
        P[2]=1;
        
        for(int i=3;i<=n;i++)
        {
            int max=P[i-1];
            
            for(int j=2;j<=i-1;j++)
            {
                if(max<j*Math.max(P[i-j],i-j))
                    max=j*Math.max(P[i-j],i-j);
            }
            
            P[i]=max;
        }
        
        return P[n];
    }
}