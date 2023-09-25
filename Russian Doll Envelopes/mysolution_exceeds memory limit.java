class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        
        if(n==0)
            return 0;
        
        int row=0,col=0;
        int ans=1;
        
        for(int i=0;i<n;i++)
        {
            if(row<envelopes[i][0])
                row=envelopes[i][0];
            
            if(col<envelopes[i][1])
                col=envelopes[i][1];
        }
        
        // N[i][j]: whether an envelope with width=i and height=j exists. 1 exist; 0 not exist;
        int[][] N=new int[row+1][col+1];
        // L[i][j]: max num of envelopes with width>=i and height>=j.
        int[][] L=new int[row+1][col+1];
        // M[i][j]: max value of L matrix in the range of [i:row][j:col]
        int[][] M=new int[row+1][col+1];
        
        for(int i=0;i<n;i++)
        {
            N[envelopes[i][0]][envelopes[i][1]]=1;
        }
        
        M[row][col]=N[row][col];
        L[row][col]=N[row][col];
        
        for(int i=row-1;i>=1;i--)
        {
            L[i][col]=N[i][col];
            M[i][col]=Math.max(L[i][col],M[i+1][col]);
        }
        
        for(int j=col-1;j>=1;j--)
        {
            L[row][j]=N[row][j];
            M[row][j]=Math.max(L[row][j],M[row][j+1]);
        }
        
        for(int i=row-1;i>=1;i--)
        {
            for(int j=col-1;j>=1;j--)
            {
                
                L[i][j]=M[i+1][j+1]+N[i][j];
                
                M[i][j]=Math.max(Math.max(M[i+1][j],M[i][j+1]),L[i][j]);
                
                if(ans<L[i][j])
                    ans=L[i][j];
            }
        }
        
        return ans;
    }

}