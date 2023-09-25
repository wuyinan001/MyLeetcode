class Trie:
    
    class TrieNode:
        def __init__(self,character=None):
            self.character=character
            self.children={}
            self.terminate=False
        
        def getChild(self,char):
            if char in self.children.keys():
                return self.children[char]
            else:
                return None
        
        def setTerminate(self,t):
            self.terminate=t
        
        def getChar(self):
            return self.character
        
        def addWord(self,word):
            if word==None or word=="":
                return
            
            c=word[0]
            node=self.getChild(c)
            
            if node==None:
                node=self.__class__(c)
                self.children[c]=node
            
            if len(word)==1:
                node.setTerminate(True)
            else:
                node.addWord(word[1:])
        
    
    def __init__(self):
        self.root=self.TrieNode()
        

    def insert(self, word: str) -> None:
        self.root.addWord(word)
    
    def search2(self,word,node):
        if word=="":
            return node.terminate
        
        c=word[0]
        if c not in node.children.keys():
            return False
        
        return self.search2(word[1:],node.getChild(c))
    
    def search(self, word: str) -> bool:
        return self.search2(word,self.root)

    def startsWith2(self,word,node):
        if word=="":
            return True
        
        c=word[0]
        if c not in node.children.keys():
            return False
        
        return self.startsWith2(word[1:],node.getChild(c))
        
    def startsWith(self, prefix: str) -> bool:
        return self.startsWith2(prefix,self.root)


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)