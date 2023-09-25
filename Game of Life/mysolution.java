class Solution {
    
    int n,m;
    
    private void copyArray(int[][] board, int[][] copy)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                copy[i][j]=board[i][j];
            }
        }
    }
    
    public void gameOfLife(int[][] board) {
        
        n=board.length;
        m=board[0].length;
        
        int[][] copy=new int[n][m];
        
        copyArray(board,copy);
        
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count=0;

                for(int[] dir:dirs)
                {
                    int x=i+dir[0], y=j+dir[1];

                    if(x>=0&&x<n&&y>=0&&y<m)
                    {
                        if(copy[x][y]==1)
                            count++;
                    }
                }

                if(count<2||count>3)
                    board[i][j]=0;
                else if(count==3)
                    board[i][j]=1;

            }
        }
            
    }
}