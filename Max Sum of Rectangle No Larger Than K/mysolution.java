class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        // L[i][j]: accumulative sum in rect from [0][0] to [i][j]
        int[][] L=new int[n][m];
        
        L[0][0]=matrix[0][0];
        
        for(int i=1;i<n;i++)
        {
            L[i][0]=L[i-1][0]+matrix[i][0];
        }
        
        for(int j=1;j<m;j++)
        {
            L[0][j]=L[0][j-1]+matrix[0][j];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                L[i][j]=L[i-1][j]+L[i][j-1]+matrix[i][j]-L[i-1][j-1];
            }
        }
        
        int max=-10000;
        
        for(int dx=1;dx<=n;dx++)
        {
            for(int dy=1;dy<=m;dy++)
            {
                for(int i=0;i<=n-1-dx+1;i++)
                {
                    for(int j=0;j<=m-1-dy+1;j++)
                    {
                        int i1=i,j1=j,i2=i+dx-1,j2=j+dy-1;
                        int area;
                        
                        if(i1==0&&j1==0)
                            area=L[i2][j2];
                        else if(i1==0&&j1!=0)
                            area=L[i2][j2]-L[i2][j1-1];
                        else if(i1!=0&&j1==0)
                            area=L[i2][j2]-L[i1-1][j2];
                        else
                            area=L[i2][j2]-L[i2][j1-1]-L[i1-1][j2]+L[i1-1][j1-1];
                        
                        
                        if(max<area&&area<=k)
                            max=area;
                        if(max==k)
                            return k;
                    }
                }
            }
        }
        
        return max;
    }
}