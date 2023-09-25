class TrieNode:
    def __init__(self,char=None):
        self.char=char
        self.pnt=0
        self.cnt=0
        self.children={}
    
    def getChild(self,char):
        if char in self.children:
            return self.children[char]
        return None
    
    def addWord(self,word):
        if word==None or word=="":
            return
        
        c=word[0]
        child=self.getChild(c)
        
        if child==None:
            child=TrieNode(c)
            self.children[c]=child
        
        child.pnt+=1
        
        if len(word)==1:
            child.cnt+=1
        else:
            child.addWord(word[1:])

class Trie:

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word: str) -> None:
        self.root.addWord(word)

    def countWordsEqualTo(self, word: str) -> int:        
        curr=self.root
        for i in range(len(word)):
            if word[i] not in curr.children:
                return 0
            
            curr=curr.getChild(word[i])
            if i==len(word)-1:
                return curr.cnt
        

    def countWordsStartingWith(self, prefix: str) -> int:
        curr=self.root
        for i in range(len(prefix)):
            if prefix[i] not in curr.children:
                return 0
            
            curr=curr.getChild(prefix[i])
            if i==len(prefix)-1:
                return curr.pnt

    def erase(self, word: str) -> None:
        if self.countWordsEqualTo(word)==0:
            return
        
        curr=self.root
        for c in word:
            curr=curr.children[c]
            curr.pnt-=1
        
        curr.cnt-=1


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.countWordsEqualTo(word)
# param_3 = obj.countWordsStartingWith(prefix)
# obj.erase(word)