class Solution {
    public int countBattleships(char[][] board) {
        
        int n=board.length, m=board[0].length;
        
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        
        Queue<int[]> queue=new LinkedList();
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X')
                {
                    queue.add(new int[]{i,j});
                    board[i][j]='.';
                    boolean rowDiff=false;
                    boolean colDiff=false;
                    
                    while(!queue.isEmpty())
                    {
                        int[] temp=queue.remove();
                        
                        if(temp[0]!=i)
                            rowDiff=true;
                        
                        if(temp[1]!=j)
                            colDiff=true;
                        
                        for(int[] dir:dirs)
                        {
                            int x=temp[0]+dir[0], y=temp[1]+dir[1];
                            
                            if(x>=0&&x<n&&y>=0&&y<m&&board[x][y]=='X')
                            {
                                board[x][y]='.';
                                queue.add(new int[]{x,y});
                            }
                        }
                    }
                    
                    if(!rowDiff||!colDiff)
                        ans++;
                }
            }
            
        }
        
        return ans;
    }
}