class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        
        if(n==0)
            return 0;
        
        int m=matrix[0].length;
        
        if(m==0)
            return 0;
        
        // c[i][j] counts maximum square with right bottom corner at (i,j)
        int[][] c=new int[n][m];
        int max=0;
        
        for(int i=0;i<n;i++)
        {
            if(matrix[i][0]=='1')
                c[i][0]=1;
            else
                c[i][0]=0;
            
            if(max<c[i][0])
                max=c[i][0];
        }
        
        for(int i=0;i<m;i++)
        {
            if(matrix[0][i]=='1')
                c[0][i]=1;
            else
                c[0][i]=0;
            
            if(max<c[0][i])
                max=c[0][i];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]=='0')
                    c[i][j]=0;
                else
                {
                    int lmin;
                    int l1=(int)Math.sqrt(c[i-1][j-1]);
                    int l2=(int)Math.sqrt(c[i-1][j]);
                    int l3=(int)Math.sqrt(c[i][j-1]);
                    
                    lmin=min(min(l1,l2),l3);
                    
                    c[i][j]=(1+lmin)*(1+lmin);
                }
                
                if(max<c[i][j])
                    max=c[i][j];
            }
        }
        
        return max;
    }
    
    private int min(int a, int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }
}