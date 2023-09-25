class Solution:
    
    def __init__(self):
        self.n=0
        self.m=0
        self.visited=None
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
    
    def backTrack(self,board,word,index,row,col):
        if index==len(word):
            return True
        
        c=word[index]
        
        if row<0 or row>=self.n or col<0 or col>=self.m or self.visited[row][col] or board[row][col]!=c:
            return False
        
        self.visited[row][col]=True
        for dir1 in self.dirs:
            x=row+dir1[0]
            y=col+dir1[1]
            if self.backTrack(board,word,index+1,x,y):
                self.visited[row][col]=False
                return True
        
        self.visited[row][col]=False
        return False
            
    
    def find(self,board,word):
        for i in range(self.n):
            for j in range(self.m):
                if self.backTrack(board,word,0,i,j):
                    return True
        return False
    
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.n=len(board)
        self.m=len(board[0])
        self.visited=[[False for j in range(self.m)] for i in range(self.n)]
        
        ans=[]
        
        for word in words:
            if self.find(board,word):
                ans.append(word)
        
        return ans