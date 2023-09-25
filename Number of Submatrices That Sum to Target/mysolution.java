class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int n=matrix.length, m=matrix[0].length;
        
        int[][] cum=new int[n][m];
        
        cum[0][0]=matrix[0][0];
        
        for(int i=1;i<n;i++)
            cum[i][0]=cum[i-1][0]+matrix[i][0];
        
        for(int j=1;j<m;j++)
            cum[0][j]=cum[0][j-1]+matrix[0][j];
        
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
            {
                cum[i][j]=cum[i-1][j]+cum[i][j-1]+matrix[i][j]-cum[i-1][j-1];
            }
        
        int sum=0;
        
        for(int rs=0;rs<n;rs++)
        {
            for(int cs=0;cs<m;cs++)
            {
                for(int re=rs;re<n;re++)
                {
                    for(int ce=cs;ce<m;ce++)
                    {
                        int area=0;
                        
                        if(rs==0&&cs==0)
                        {
                            area=cum[re][ce];   
                        }
                        else if(rs==0)
                        {
                            area=cum[re][ce]-cum[re][cs-1];
                        }
                        else if(cs==0)
                        {
                            area=cum[re][ce]-cum[rs-1][ce];
                        }
                        else
                        {
                            area=cum[re][ce]-cum[rs-1][ce]-cum[re][cs-1]+cum[rs-1][cs-1];
                        }
                        
                        if(area==target)
                            sum++;
                    }
                }
            }
        }
        
        return sum;
    }
}