class Solution {
    public void solve(char[][] board) {
        
        int n=board.length;
        
        if(n==0)
            return;
        
        int m=board[0].length;
        
        Queue<int[]> queue=new LinkedList<>();
        // marked: false:'X' or 'O' surrounded  true:'O' not surrounded
        boolean[][] marked=new boolean[n][m];
        int[][] move={{1,0},{-1,0},{0,1},{0,-1}};
        
        //print(marked);
        
        // mark all the Os that connected to the borders as 2
        for(int i=0;i<n;i++)
        {   
            if(i==0||i==n-1)
            {
                for(int j=0;j<m;j++)
                {
                    if(board[i][j]=='O'&&!marked[i][j])
                    {
                        queue.add(new int[]{i,j});
                        marked[i][j]=true;
                    }
                    
                    while(!queue.isEmpty())
                    {
                        int[] pos=queue.remove();
                        for(int k=0;k<4;k++)
                        {
                            int x=pos[0]+move[k][0], y=pos[1]+move[k][1];
                            if(x>=0&&x<n&&y>=0&&y<m&&!marked[x][y]&&board[x][y]=='O')
                            {
                                queue.add(new int[]{x,y});
                                marked[x][y]=true;
                            }
                        }
                    }
                }
            }
            else
            {
                for(int j=0;j<m;j=j+m-1)
                {
                    if(board[i][j]=='O'&&!marked[i][j])
                    {
                        queue.add(new int[]{i,j});
                        marked[i][j]=true;
                    }
                    
                    while(!queue.isEmpty())
                    {
                        int[] pos=queue.remove();
                        for(int k=0;k<4;k++)
                        {
                            int x=pos[0]+move[k][0], y=pos[1]+move[k][1];
                            if(x>=0&&x<n&&y>=0&&y<m&&!marked[x][y]&&board[x][y]=='O')
                            {
                                queue.add(new int[]{x,y});
                                marked[x][y]=true;
                            }
                        }
                    }
                }
            }
        }
        
        //print(marked);
        
        // Change all the rest 'O' to 'X'
        for(int i=1;i<=n-2;i++)
        {
            for(int j=1;j<=m-2;j++)
            {
                if(board[i][j]=='O'&&!marked[i][j])
                {
                    queue.add(new int[]{i,j});
                    board[i][j]='X';
                }

                while(!queue.isEmpty())
                {
                    int[] pos=queue.remove();
                    for(int k=0;k<4;k++)
                    {
                        int x=pos[0]+move[k][0], y=pos[1]+move[k][1];
                        if(x>=0&&x<n&&y>=0&&y<m&&!marked[x][y]&&board[x][y]=='O')
                        {
                            queue.add(new int[]{x,y});
                            board[x][y]='X';
                        }
                    }
                }
            }
        }
    }
    
    private void print(boolean[][] marked)
    {
        int n=marked.length;
        int m=marked[0].length;

        System.out.println("Marked:");

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(marked[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
}