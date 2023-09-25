class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n=matrix.length;
        
        if(n==0)
            return;
        
        Set<Integer> rows=new HashSet<>();
        Set<Integer> cols=new HashSet<>();
        
        int m=matrix[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                if(matrix[i][j]==0)
                {
                    rows.add(i);
                    cols.add(j);
                }
        }
        
        for(int i:rows)
        {
            for(int j=0;j<m;j++)
                matrix[i][j]=0;
        }
        
        for(int j:cols)
        {
            for(int i=0;i<n;i++)
                matrix[i][j]=0;
        }
        
    }
}