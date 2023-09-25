class Solution {
    
    private int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    private void print(char[][] board)
    {
        int n=board.length,m=board[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(board[i][j]+'\t');
            }
            System.out.println();
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> ans=new ArrayList<>();
        
        for(String word:words)
        {
            //System.out.println("Board:");
            //print(board);
            if(search(board,word))
                ans.add(word);
        }
        
        return ans;
        
    }
    
    // Find if board has the string word
    private boolean search(char[][] board, String word)
    {
        int n=board.length, m=board[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(search(board,word,0,i,j))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean search(char[][] board, String word, int index, int row, int col)
    {
        if(index==word.length())
            return true;
        
        int n=board.length, m=board[0].length;
        
        if(row<0||row>=n||col<0||col>=m)
            return false;
        
        if(board[row][col]==word.charAt(index))
        {
            board[row][col]='#';
            for(int i=0;i<4;i++)
            {
                if(search(board,word,index+1,row+dir[i][0],col+dir[i][1]))
                {
                    board[row][col]=word.charAt(index);
                    return true;
                }
            }
            
            board[row][col]=word.charAt(index);
            return false;
        }
        
        return false;
    }
}