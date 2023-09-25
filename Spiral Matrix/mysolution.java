class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans=new ArrayList<>();
        
        int n=matrix.length;
        
        if(n==0)
            return ans;
        
        int m=matrix[0].length;
        
        if(m==0)
            return ans;
        
        // direction: 0 right, 1 down, 2 left, 3 up
        int direction=0;
        int col_start=0,col_end=m-1;
        int row_start=1,row_end=n-1;
        int right_row=0,down_col=m-1,left_row=n-1,up_col=0;
        
        while(true)
        {
            
            if(direction==0)
            {
                if(col_start>col_end)
                    break;
                
                for(int j=col_start;j<=col_end;j++)
                {
                    ans.add(matrix[right_row][j]);
                }
                
                right_row++;
                int t=col_start;
                col_start=col_end-1;
                col_end=t;
                direction=1;
            }
            else if(direction==1)
            {
                if(row_start>row_end)
                    break;
                
                for(int i=row_start;i<=row_end;i++)
                {
                    ans.add(matrix[i][down_col]);
                }
                
                down_col--;
                int t=row_start;
                row_start=row_end-1;
                row_end=t;
                direction=2;
            }
            else if(direction==2)
            {
                if(col_start<col_end)
                    break;
                
                for(int j=col_start;j>=col_end;j--)
                {
                    ans.add(matrix[left_row][j]);
                }
                
                left_row--;
                int t=col_start;
                col_start=col_end+1;
                col_end=t;
                direction=3;
            }
            else 
            {
                if(row_start<row_end)
                    break;
                
                for(int i=row_start;i>=row_end;i--)
                {
                    ans.add(matrix[i][up_col]);
                }
                
                up_col++;
                int t=row_start;
                row_start=row_end+1;
                row_end=t;
                direction=0;
            }
        }
        
        //System.out.println("col_start: "+col_start);
        //System.out.println("col_end: "+col_end);
        
        
        return ans;
    }
}