class TrieNode:
    def __init__(self,char=None):
        self.char=char
        self.children={}
        self.terminate=False
    
    def getChild(self,char):
        return self.children.get(char,None)
    
    def setTerminate(self,t):
        self.terminate=t
    
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

class WordDictionary:

    def __init__(self):
        self.root=TrieNode()

    def addWord(self, word: str) -> None:
        self.root.addWord(word)
    
    def search2(self,node,word):
        if word=="":
            return node.terminate
        
        c=word[0]
        
        if c in node.children:
            return self.search2(node.children[c],word[1:])
        elif c==".":
            for child in node.children.values():
                if self.search2(child,word[1:]):
                    return True
            return False
        else:
            return False
    
    def search(self, word: str) -> bool:
        return self.search2(self.root,word)
    

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)