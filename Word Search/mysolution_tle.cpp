class Solution {
public:
    vector<vector<int>> dirs{{1,0},{-1,0},{0,1},{0,-1}};
    
public:
    bool backTrack(vector<vector<char>>& board, int row, int col, string word, int index)
    {
        if(index==word.size())
            return true;
        
        int n=board.size(), m=board[0].size();
        
        if(row<0||row>=n||col<0||col>=m)
            return false;
        
        char c=board[row][col];
        
        if(c==word[index])
        {
            board[row][col]='#';
            for(auto d:dirs)
            {
                int x=row+d[0], y=col+d[1];
                if(backTrack(board,x,y,word,index+1))
                {
                    board[row][col]=c;
                    return true;
                }
            }
            board[row][col]=c;
        }
        
        return false;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        int n=board.size(), m=board[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(backTrack(board,i,j,word,0))
                {
                    return true;
                }
            }
        }

        return false;
    }
};