class Solution {
    
    private char[][] BOARD;
    private int ROWS;
    private int COLS;
    private int[][] MOVE={{1,0},{-1,0},{0,1},{0,-1}};
    
    public boolean exist(char[][] board, String word) {
        
        this.BOARD=board;
        this.ROWS=board.length;
        this.COLS=board[0].length;
        
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLS;j++)
            {
                if(backTrack(i,j,word,0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean backTrack(int row, int col, String word, int index)
    {
        if(index>=word.length())
            return true;
        
        if(row<0||row>=ROWS||col<0||col>=COLS||word.charAt(index)!=BOARD[row][col])
            return false;
        
        boolean result=false;
        
        BOARD[row][col]='#';
        
        for(int i=0;i<4;i++)
        {
            if(backTrack(row+MOVE[i][0],col+MOVE[i][1],word,index+1))
            {
                result=true;
                break;
            }
        }
        
        BOARD[row][col]=word.charAt(index);
        return result;
    }
}