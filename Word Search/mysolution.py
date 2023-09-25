class Solution:
    def __init__(self):
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        self.n=0
        self.m=0
    
    def backTrack(self,board,row,col,word,index):
        if index==len(word):
            return True
        
        if row<0 or row>=self.n or col<0 or col>=self.m or board[row][col]!=word[index]:
            return False
        
        board[row][col]='#'
        for dir1 in self.dirs:
            x=row+dir1[0]
            y=col+dir1[1]
            if self.backTrack(board,x,y,word,index+1):
                return True
        
        board[row][col]=word[index]
        return False
            
        
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.n=len(board)
        self.m=len(board[0])
        
        for i in range(self.n):
            for j in range(self.m):
                if self.backTrack(board,i,j,word,0):
                    return True
        
        return False