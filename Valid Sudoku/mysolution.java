class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set=new HashSet<Character>();
        
        for(int i=0;i<9;i++)
        {   
            int count=0;           
            set.clear();
            
            for(int j=0;j<9;j++)
            {

                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
            
            if(count>set.size()-1)
                return false;
        }
        
        for(int j=0;j<9;j++)
        {   
            int count=0;
            set.clear();
            
            for(int i=0;i<9;i++)
            {

                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
            
            if(count>set.size()-1)
                return false;
        }
        
        int count=0;
        set.clear();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        count=0;
        set.clear();
        for(int i=0;i<3;i++)
        {
            for(int j=3;j<6;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        
        count=0;
        set.clear();
        for(int i=0;i<3;i++)
        {
            for(int j=6;j<9;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        count=0;
        set.clear();
        for(int i=3;i<6;i++)
        {
            for(int j=0;j<3;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        count=0;
        set.clear();
        for(int i=3;i<6;i++)
        {
            for(int j=3;j<6;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        
        count=0;
        set.clear();
        for(int i=3;i<6;i++)
        {
            for(int j=6;j<9;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        count=0;
        set.clear();
        for(int i=6;i<9;i++)
        {
            for(int j=0;j<3;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        count=0;
        set.clear();
        for(int i=6;i<9;i++)
        {
            for(int j=3;j<6;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        
        count=0;
        set.clear();
        for(int i=6;i<9;i++)
        {
            for(int j=6;j<9;j++)
            {
                set.add(board[i][j]);
                
                if(board[i][j]!='.')
                    count++;
            }
        }
        
        if(count>set.size()-1)
                return false;
        
        return true;
    }
}