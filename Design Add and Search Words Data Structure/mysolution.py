class TrieNode:
    def __init__(self,character=None):
        self.character=character
        self.children={}
        self.terminate=False
    
    def setTerminate(self,t):
        self.terminate=t
    
    def getChild(self,c):
        if c in self.children.keys():
            return self.children[c]
        else:
            return None
    
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

class WordDictionary:

    def __init__(self):
        self.root=TrieNode()

    def addWord(self, word: str) -> None:
        self.root.addWord(word)
    
    def search2(self,word,node):
        if word=="":
            return node.terminate
        
        #print(type(node))
        
        c=word[0]
        if c==".":
            for child in node.children.keys():
                if self.search2(word[1:],node.children[child]):
                    return True
            return False
        elif c not in node.children.keys():
            return False
        else:
            return self.search2(word[1:],node.children[c])
            

    def search(self, word: str) -> bool:
        return self.search2(word,self.root)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)