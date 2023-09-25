class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int n=board.length, m=board[0].length;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        
        Set<int[]> set=new HashSet();
        
        if(color=='B')
        {
            for(int[] dir:dirs)
            {
                int x=rMove+dir[0], y=cMove+dir[1];

                if(x>=0&&x<n&&y>=0&&y<m&&board[x][y]=='W')
                {
                    set.add(dir);
                }
            }
        }
        else
        {
            for(int[] dir:dirs)
            {
                int x=rMove+dir[0], y=cMove+dir[1];

                if(x>=0&&x<n&&y>=0&&y<m&&board[x][y]=='B')
                {
                    set.add(dir);
                }
            }
        }
        
        if(color=='B')
        {
            for(int[] dir:set)
            {
                int x=rMove+dir[0], y=cMove+dir[1];
                char c=board[x][y];

                while(x>=0&&x<n&&y>=0&&y<m&&board[x][y]==c)
                {
                    x+=dir[0];
                    y+=dir[1];
                }

                if(x>=0&&x<n&&y>=0&&y<m&&board[x][y]=='B')
                    return true;
            }
            
            return false;
        }
        else
        {
            for(int[] dir:set)
            {
                int x=rMove+dir[0], y=cMove+dir[1];
                char c=board[x][y];

                while(x>=0&&x<n&&y>=0&&y<m&&board[x][y]==c)
                {
                    x+=dir[0];
                    y+=dir[1];
                }

                if(x>=0&&x<n&&y>=0&&y<m&&board[x][y]=='W')
                    return true;
            }
            
            return false;
        }
        
    }
}