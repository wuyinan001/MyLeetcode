class Solution {
    public int numTrees(int n) {
        
        if(n==0||n==1)
            return 1;
        
        int[] N=new int[n+1];
        
        N[0]=1;
        N[1]=1;
        
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<=i-1;j++)
            {
                N[i]=N[i]+N[j]*N[i-1-j];
            }
        }
        
        return N[n];
    }
}