class Solution {
    public int numSubmat(int[][] mat) {
        
        int n=mat.length, m=mat[0].length;
        int ans=0;
        int[][] cum=new int[n][m];
        
        cum[0][0]=mat[0][0];
        
        for(int j=1;j<m;j++)
            cum[0][j]=cum[0][j-1]+mat[0][j];
        
        for(int i=1;i<n;i++)
            cum[i][0]=cum[i-1][0]+mat[i][0];
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
                cum[i][j]=cum[i-1][j]+cum[i][j-1]+mat[i][j]-cum[i-1][j-1];
        }
        
        for(int re=0;re<n;re++)
        {
            for(int ce=0;ce<m;ce++)
            {
                if(cum[re][ce]==(re+1)*(ce+1))
                    ans++;
            }
        }
        
        for(int rs=1;rs<n;rs++)
        {
            for(int re=rs;re<n;re++)
            {
                for(int ce=0;ce<m;ce++)
                {
                    if(cum[re][ce]-cum[rs-1][ce]==(re-rs+1)*(ce+1))
                        ans++;
                }
            }
        }
        
        for(int cs=1;cs<m;cs++)
        {
            for(int re=0;re<n;re++)
            {
                for(int ce=cs;ce<m;ce++)
                {
                    if(cum[re][ce]-cum[re][cs-1]==(re+1)*(ce-cs+1))
                        ans++;
                }
            }
        }
        
        for(int rs=1;rs<n;rs++)
        {
            for(int cs=1;cs<m;cs++)
            {
                for(int re=rs;re<n;re++)
                {
                    for(int ce=cs;ce<m;ce++)
                    {
                        if((cum[re][ce]-cum[rs-1][ce]-cum[re][cs-1]+cum[rs-1][cs-1])==(re-rs+1)*(ce-cs+1))
                            ans++;
                    }
                }
            }
        }
        
        return ans;
    }
}