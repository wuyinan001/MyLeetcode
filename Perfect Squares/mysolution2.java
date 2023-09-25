class Solution {
    public int numSquares(int n) {
        
        int[] P=new int[n+1];
        
        for(int i=1;i*i<=n;i++)
            P[i*i]=1;
        
        for(int i=2;i<=n;i++)
        {
            if(P[i]!=0)
                continue;
            
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<i;j++)
            {
                min=Math.min(min,P[i-j*j]);
            }
            
            P[i]=1+min;
        }
        
        return P[n];
    }
}