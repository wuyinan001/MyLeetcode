class NumMatrix {
    
    boolean isEmpty=false;
    int[][] cum;
    
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        if(n==0)
        {
            isEmpty=true;
            return;
        }
        
        int m=matrix[0].length;
        
        cum=new int[n][m];
        
        for(int j=0;j<m;j++)
        {
            cum[0][j]=matrix[0][j];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                cum[i][j]=cum[i-1][j]+matrix[i][j];
            }
        }
        
        for(int j=1;j<m;j++)
        {
            for(int i=0;i<n;i++)
            {
                cum[i][j]=cum[i][j]+cum[i][j-1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(isEmpty)
            return 0;
        
        
        if(row1==0&&col1==0)
            return cum[row2][col2];
        
        if(row1==0)
            return cum[row2][col2]-cum[row2][col1-1];
        
        if(col1==0)
            return cum[row2][col2]-cum[row1-1][col2];
        
        return cum[row2][col2]-cum[row1-1][col2]-cum[row2][col1-1]+cum[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */