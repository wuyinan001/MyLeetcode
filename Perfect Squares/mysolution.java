class Solution {
    public int numSquares(int n) {
        
        // L[i] shows min number of perfect numbers to sum to i
        int[] L=new int[n+1];
        // ps[i]=0 if i is not a perfect square number; 1 if i is a perfect square number
        int[] ps=new int[n+1];
        
        for(int i=1;i<=n;i++)
        {
            if(isSquare(i))
            {
                L[i]=1;
                ps[i]=1;
            }
            else
            {
                L[i]=i;
                for(int j=1;j<i;j++)
                {
                    if((ps[j]==1)&&(L[i]>L[i-j]+1))
                        L[i]=L[i-j]+1;
                }
            }
        }
        
        return L[n];
    }
    
    private boolean isSquare(int n)
    {   
        double x=Math.sqrt(n);
        
        if((x-Math.floor(x))==0)
            return true;
        else
            return false;
    }
}