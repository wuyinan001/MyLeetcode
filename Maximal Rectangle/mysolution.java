class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n=matrix.length;
        
        if(n==0)
            return 0;
        
        int m=matrix[0].length;
        
        int[][] L=new int[n][m];
        
        L[0][0]=matrix[0][0]-'0';
        
        for(int i=1;i<n;i++)
            L[i][0]=L[i-1][0]+matrix[i][0]-'0';
        
        for(int j=1;j<m;j++)
            L[0][j]=L[0][j-1]+matrix[0][j]-'0';
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                L[i][j]=L[i-1][j]+L[i][j-1]+matrix[i][j]-'0'-L[i-1][j-1];
            }
        }
        
        int ans=0;
        
        // i:left top corner row index; j: left top corner col index
        // row: num of rows; col: num of cols
        // i+row-1<=n-1
        // j+col-1<=m-1
        for(int row=1;row<=n;row++)
        {
            for(int col=1;col<=m;col++)
            {
                for(int i=0;i<=n-row;i++)
                {
                    for(int j=0;j<=m-col;j++)
                    {
                        int area;
                        
                        if(i==0&&j==0)
                            area=L[i+row-1][j+col-1];
                        else if(i==0)
                            area=L[i+row-1][j+col-1]-L[i+row-1][j-1];
                        else if(j==0)
                            area=L[i+row-1][j+col-1]-L[i-1][j+col-1];
                        else
                            area=L[i+row-1][j+col-1]-L[i+row-1][j-1]-L[i-1][j+col-1]+L[i-1][j-1];
                        
                        //if(i==1&&j==2&&row==2&&col==3)
                          //  System.out.println("area: "+area);
                        
                        if(ans<area&&area==row*col)
                            ans=area;
                    }
                }
            }
        }
        
        return ans;
    }
}