class Solution {
    
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    private boolean contains(char[][] board, String word)
    {
        int n=board.length, m=board[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(backTrack(board,word,0,i,j))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean backTrack(char[][] board, String word, int index, int row, int col)
    {
        //print(board);
        if(index==word.length())
            return true;
        
        char c=word.charAt(index);
        int n=board.length, m=board[0].length;
        
        if(board[row][col]==c)
        {
            if(index==word.length()-1)
                return true;
            
            board[row][col]='#';
            
            for(int i=0;i<4;i++)
            {
                int x=row+dir[i][0], y=col+dir[i][1];
                if(x>=0&&x<n&&y>=0&&y<m&&board[x][y]!='#')
                {
                    if(backTrack(board,word,index+1,x,y))
                    {
                        board[row][col]=c;
                        return true;
                    }
                }
            }
            
            board[row][col]=c;
            return false;
        }
        
        return false;
    }
    
    private void print(char[][] board)
    {
        int n=board.length, m=board[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                System.out.print(board[i][j]+"\t");
            System.out.println();
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> ans=new ArrayList();
        
        
        for(String s:words)
        {
            //print(board);
            if(contains(board,s))
                ans.add(s);
        }
            
        return ans;
    }
}