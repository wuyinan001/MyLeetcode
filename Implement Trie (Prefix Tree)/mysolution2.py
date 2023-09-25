class TrieNode:
    def __init__(self,char=None):
        self.char=char
        self.children={}
        self.terminate=False
    
    def setTerminate(self,t):
        self.terminate=t
    
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
            
        if len(word)==1:
            child.setTerminate(True)
        else:
            child.addWord(word[1:])
    
class Trie:

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word: str) -> None:
        self.root.addWord(word)

    def search(self, word: str) -> bool:
        if word=="":
            return True
        
        node=self.root
        
        for c in word:
            if c in node.children:
                node=node.getChild(c)
            else:
                return False
            
        return node.terminate
        
        

    def startsWith(self, prefix: str) -> bool:
        if prefix=="":
            return True
        
        node=self.root
        
        for c in prefix:
            if c in node.children:
                node=node.getChild(c)
            else:
                return False
            
        return True