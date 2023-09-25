class Solution {
public:
    vector<vector<int>> dirs{{1,0},{-1,0},{0,1},{0,-1}};
    
    bool backTrack(vector<vector<char>>& board, int row, int col, string word, int index)
    {
        if(index==word.size())
            return true;
        
        int n=board.size(), m=board[0].size();
        char c=word[index];
        
        if(row<0||row>=n||col<0||col>=m||board[row][col]!=c)
            return false;
        
        board[row][col]='#';
        
        for(auto dir:dirs)
        {
            int x=row+dir[0], y=col+dir[1];
            if(backTrack(board,x,y,word,index+1))
            {
                board[row][col]=c;
                return true;
            }
        }
        
        board[row][col]=c;
        return false;
    }
    
    bool findWord(vector<vector<char>>& board, string word)
    {
        int n=board.size(), m=board[0].size();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(backTrack(board,i,j,word,0))
                    return true;
            }
        }
        
        return false;
    }
    
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> ans;
        
        for(auto s:words)
        {
            if(findWord(board,s))
                ans.push_back(s);
        }
        
        return ans;
    }
};