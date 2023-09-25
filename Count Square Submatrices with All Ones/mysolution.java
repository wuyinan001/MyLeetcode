class Solution {
    public int countSquares(int[][] matrix) {
        
        int n=matrix.length, m=matrix[0].length;
        
        int[][] cum=new int[n][m];
        cum[0][0]=matrix[0][0];
        
        for(int i=1;i<n;i++)
            cum[i][0]=cum[i-1][0]+matrix[i][0];
        
        for(int j=1;j<m;j++)
            cum[0][j]=cum[0][j-1]+matrix[0][j];
        
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
                cum[i][j]=cum[i-1][j]+cum[i][j-1]+matrix[i][j]-cum[i-1][j-1];
        
        int count=0;
        
        int side=Math.min(n,m);
        
        for(int k=1;k<=side;k++)
        {
            for(int rs=0;rs<=n-k;rs++)
            {
                for(int cs=0;cs<=m-k;cs++)
                {
                    int re=rs+k-1, ce=cs+k-1;
                    int area=0;
                    
                    if(rs==0&&cs==0)
                        area=cum[re][ce];
                    else if(cs==0)
                        area=cum[re][ce]-cum[rs-1][ce];
                    else if(rs==0)
                        area=cum[re][ce]-cum[re][cs-1];
                    else
                        area=cum[re][ce]-cum[rs-1][ce]-cum[re][cs-1]+cum[rs-1][cs-1];
                    
                    if(area==k*k)
                        count++;
                }
            }
        }
        
        return count;
    }
}