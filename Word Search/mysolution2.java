class Solution {
    
    private final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        
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
    
    private boolean backTrack(char[][] board, String word, int index, int ROW, int COL)
    {
        //System.out.println(word);
        //System.out.println("ROW: "+ROW);
        //System.out.println("COL: "+COL);
        
        if(index>=word.length())
            return true;
        
        if(ROW<0||ROW>=board.length||COL<0||COL>=board[0].length)
            return false;

        
        if(board[ROW][COL]==word.charAt(index))
        {
            board[ROW][COL]='#';
            for(int i=0;i<4;i++)
            {
                if(backTrack(board,word,index+1,ROW+dir[i][0],COL+dir[i][1]))
                    return true;
            }
            
            board[ROW][COL]=word.charAt(index);
            
            return false;
        }
        
        return false;
    }
}