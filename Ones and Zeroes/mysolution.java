class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // K[i,a,b]=max{K[i-1,a-ai,b-bi]+1,K[i-1,a,b]}
        int k=strs.length;
        
        if(k==0)
            return k;
        
        // K[i][j][l] counts the maximum num of strings from strs[0] to strs[i-1] under j of 0s and l of 1s limit
        // K[0][j][l]=0: if there is no string selected, the num of strings is 0
        int[][][] K=new int[k+1][m+1][n+1];
        
        // M[i][0] holds num of 0s in str[i]; M[i][1] holds num of 1s in str[i]
        int[][] M=new int[k][2];
        
        for(int i=0;i<k;i++)
        {
            M[i][1]=ones(strs[i]);
            M[i][0]=strs[i].length()-M[i][1];
        }
        
        for(int i=1;i<=k;i++)
        {
            if(M[i-1][0]==0&&M[i-1][1]==0)
                K[i][0][0]=K[i-1][0][0]+1;
            else
                K[i][0][0]=K[i-1][0][0];
        }
        
        for(int i=1;i<=k;i++)
        {
            for(int j=1;j<=m;j++)
            {
                K[i][j][0]=K[i-1][j][0];
                    
                if(M[i-1][1]==0&&M[i-1][0]<=j&&K[i][j][0]<1+K[i-1][j-M[i-1][0]][0])
                    K[i][j][0]=1+K[i-1][j-M[i-1][0]][0];
            }
        }
        
        for(int i=1;i<=k;i++)
        {
            for(int l=1;l<=n;l++)
            {
                K[i][0][l]=K[i-1][0][l];
                    
                if(M[i-1][0]==0&&M[i-1][1]<=l&&K[i][0][l]<1+K[i-1][0][l-M[i-1][1]])
                    K[i][0][l]=1+K[i-1][0][l-M[i-1][1]];
            }
        }
        
        for(int i=1;i<=k;i++)
        {
            for(int j=1;j<=m;j++)
            {
                for(int l=1;l<=n;l++)
                {
                    K[i][j][l]=K[i-1][j][l];
                    
                    //System.out.println("i,j,l: "+i+" "+j+" "+l);
                    //System.out.println("M[i-1][0]:"+M[i-1][0]);
                    //System.out.println("M[i-1][1]:"+M[i-1][1]);
                    
                    if(M[i-1][0]<=j&&M[i-1][1]<=l&&K[i][j][l]<1+K[i-1][j-M[i-1][0]][l-M[i-1][1]])
                        K[i][j][l]=1+K[i-1][j-M[i-1][0]][l-M[i-1][1]];
                }
            }
        }
        
        return K[k][m][n];
    }
    
    private int ones(String s)
    {
        char[] array=s.toCharArray();
        
        int count=0;
        
        for(int i=0;i<array.length;i++)
        {
            if(array[i]=='1')
                count++;
        }
        
        return count;
    }
}