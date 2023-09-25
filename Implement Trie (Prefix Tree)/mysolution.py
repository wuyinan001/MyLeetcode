class TrieNode:
    def __init__(self,char=None):
        self.char=char
        self.terminate=False
        self.children={}
    
    def getChild(self,char):
        if char in self.children:
            return self.children[char]
        return None
    
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
    
class Trie:

    def __init__(self):
        self.root=TrieNode()

    def insert(self, word: str) -> None:
        self.root.addWord(word)
    
    def search2(self,node,word):
        if word=="":
            return node.terminate
        c=word[0]
        if c in node.children:
            return self.search2(node.getChild(c),word[1:])
        else:
            return False
    
    def search(self, word: str) -> bool:
        return self.search2(self.root,word)
    
    def startsWith2(self,node,word):
        if word=="":
            return True
        c=word[0]
        if c in node.children:
            return self.startsWith2(node.getChild(c),word[1:])
        else:
            return False
        
    def startsWith(self, prefix: str) -> bool:
        return self.startsWith2(self.root,prefix)


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)